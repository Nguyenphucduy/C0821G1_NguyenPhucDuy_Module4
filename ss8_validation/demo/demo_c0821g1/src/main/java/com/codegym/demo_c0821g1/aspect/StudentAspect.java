package com.codegym.demo_c0821g1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* com.codegym.demo_c0821g1.controller.StudentController.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
//        System.err.println("tên phương thức : " + nameMethod);
        logger.info("tên phương thức " + nameMethod);
    }
}
