package librarybook.borrowbooks.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After("execution(* librarybook.borrowbooks.controller.BookController.giveBook(..))")
    public  void logAfterMethod(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("tên phương thức  " + nameMethod  + "tra sach");
    }

    @Before("execution(* librarybook.borrowbooks.controller.BookController.borrow(..))")
    public  void logBeforeMethod(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("tên phương thức  " + nameMethod  + "muon sach");
    }
    @AfterReturning("execution(* librarybook.borrowbooks.controller.BookController.*(..))")
    public  void logAll(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("logggg ALLLL  " + nameMethod  );
    }

//    @AfterThrowing("execution(* librarybook.borrowbooks.controller.BookController.*(..))")
//    public  void logAfterMethod(JoinPoint joinPoint){
//        String nameMethod = joinPoint.getSignature().getName();
//        logger.info("tên phương thức " + nameMethod );
//    }

//    @Around("execution(* librarybook.borrowbooks.controller.BookController.*(..))")
//    public  void logAfterMethod(JoinPoint joinPoint){
//        String nameMethod = joinPoint.getSignature().getName();
//        logger.info("tên phương thức " + nameMethod );
//    }
}
