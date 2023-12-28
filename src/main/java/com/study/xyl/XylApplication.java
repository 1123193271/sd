package com.study.xyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.study.xyl._08_preventRepeat")
public class XylApplication {

	public static void main(String[] args) {
		SpringApplication.run(XylApplication.class, args);
	}

}
