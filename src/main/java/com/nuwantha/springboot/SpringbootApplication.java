package com.nuwantha.springboot;

import com.nuwantha.springboot.dependencyInjection.Developer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);


//---------------- related to dependency injection START -------------
        /**
         * way of getting object of Developer class that is in IOC container and run the method buildCode inside in that class
         */
//		ApplicationContext  context = SpringApplication.run(SpringbootApplication.class, args);
//		Developer obj = context.getBean(Developer.class);
//		obj.buildCode();
//---------------- related to dependency injection END -------------

    }
}
