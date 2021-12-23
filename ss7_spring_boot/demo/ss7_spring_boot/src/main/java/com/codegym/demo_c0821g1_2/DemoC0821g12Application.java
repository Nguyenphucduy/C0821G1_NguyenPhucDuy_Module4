package com.codegym.demo_c0821g1_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.codegym")
public class DemoC0821g12Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoC0821g12Application.class, args);
    }

}
