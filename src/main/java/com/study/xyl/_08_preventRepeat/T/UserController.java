package com.study.xyl._08_preventRepeat.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;
    @Autowired
    private ApplicationContext applicationContext;


    @PostMapping("/register")
    public GenericResponse<User> register(@RequestBody(required = false) User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getAllBeans")
    public void printAllBeans() {
        Map<String, Object> allBeans = applicationContext.getBeansOfType(Object.class);
        allBeans.forEach((name, bean) -> System.out.println(name + " : " + bean.getClass()));
    }
}
