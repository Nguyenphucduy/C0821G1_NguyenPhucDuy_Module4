package com.codegym.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LibraryAop {
    private static int count = 0;

    @Pointcut("execution(* com.codegym.demo.controller.BookController.borrowBook(..))")
    public void doBorrow(){}

    @After("doBorrow()")
    public void beforeBorrowBook(JoinPoint joinPoint){
        System.err.println("Có sách đã được mượn " + joinPoint.getSignature().getName() + "___vào lúc : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.demo.controller.BookController.borrowBook(..))")
    public void doReturn(){}

    @After("doReturn()")
    public void beforeReturnBook(JoinPoint joinPoint){
        System.err.println("Có sách đã được trả " + joinPoint.getSignature().getName() + "___vào lúc : " + LocalDateTime.now());
    }

    @Pointcut("execution(* com.codegym.demo.controller.BookController.*(..))")
    public void checkCountLog(){}

    @Before("checkCountLog()")
    public void count(JoinPoint joinPoint){
        System.err.println("Số thao tác " + ++count + "___vào lúc : " + LocalDateTime.now());
    }
}
