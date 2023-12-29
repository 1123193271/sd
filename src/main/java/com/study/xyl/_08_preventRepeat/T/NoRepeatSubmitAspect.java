package com.study.xyl._08_preventRepeat.T;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@Aspect
public class NoRepeatSubmitAspect {
    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(repeatSubmit)")
    public void pointCutNoRepeatSubmit(RepeatSubmit repeatSubmit){
    }

    private String buildReqSignature(HttpServletRequest req, ProceedingJoinPoint jp) {
        String clientIp = req.getRemoteAddr();
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = methodSignature.getMethod();
        String className = method.getDeclaringClass().getName();
        StringBuilder sbParams = new StringBuilder();
        for (Object arg : jp.getArgs()) {
            sbParams.append(ObjectUtils.identityToString(arg));
        }
        return String.format("%s-%s-%s-%s", clientIp, className, method, sbParams);
    }

    private String buildRedisKey(String reqSignature) {
        return "system:repeat_submit:param:" + DigestUtils.md5DigestAsHex(reqSignature.getBytes());
    }

    @Around("pointCutNoRepeatSubmit(repeatSubmit)")
    public Object around(ProceedingJoinPoint jp, RepeatSubmit repeatSubmit) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String reqSignature = buildReqSignature(request, jp);
        String key = buildRedisKey(reqSignature);
        //尝试加锁
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        long lockTime = repeatSubmit.lockTime();
        Boolean b = ops.setIfAbsent(key, "1", lockTime, TimeUnit.SECONDS);
        if (Boolean.FALSE.equals(b)) {
            throw new RuntimeException("请勿重复请求");
        }
        log.info("环绕通知执行前");
        Object proceed = jp.proceed();
        log.info("环绕通知执行后");
        return proceed;
    }
}
