package com.study.xyl._08_preventRepeat.T;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatSubmit {
    /**
     * 加锁过期时间，默认时间是5秒
     * @return 过期时间
     */
    long lockTime() default 5;
}
