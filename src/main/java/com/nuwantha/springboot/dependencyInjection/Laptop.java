package com.nuwantha.springboot.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

    public void compileCode() {
        System.out.println("Compile code with Laptop");
    }
}
