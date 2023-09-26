package com.study.xyl._01_aoptest;

import com.study.xyl._01_aoptest.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopTestApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(AopTestApplication.class, args);

        MyService myService = run.getBean(MyService.class);

        myService.doSomething();

        try {
            int result = myService.divide(10, 2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        run.close();


    }

}
