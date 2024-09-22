package com.nuwantha.springboot.dependencyInjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // says in case of confusion this class is preferred.
public class Desktop implements Computer {
    public void compileCode() {
        System.out.println("Compile code with Desktop");
    }
}
