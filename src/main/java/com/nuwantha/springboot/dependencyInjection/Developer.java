package com.nuwantha.springboot.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developer {

//   ------------------------ Without Computer interface ------------------------------------------

//    @Autowired /** field injection /
//    private final Laptop laptop; // this is a instant variable. by default instant variables are null. so we cannot access the method without DI.

    /**
     * constructor injection
     */
//    public Developer(Laptop laptop) {
//        this.laptop = laptop;
//    }

    /**
     * setter injection
     */
//    @Autowired
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }
//    public void buildCode() {
//        System.out.println("build code");
//
//        laptop.compileCode();
//    }

    // ------------------ With Computer Interface --------------------------------

    private final Computer computer;

    public Developer(@Qualifier("laptop") Computer computer) {
        this.computer = computer;
    }

    public void buildCode() {
        System.out.println("build code");

        computer.compileCode();
    }
}
