package librarybook.borrowbooks.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BookAspect {
    private static Integer borrowBook = 0,giveBackBook = 0,client = 0;
//
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing("execution(* librarybook.borrowbooks.controller.BookController.*(..))")
    public  void logAfterMethod(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("tên phương thức ném ra ngoại lệ là : " + nameMethod );
    }
//
    @After("execution(* librarybook.borrowbooks.controller.BookController.*(..))")
    public  void logAll(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
        if (nameMethod.equals("borrow")){
            logger.info( "Tên Phương thức : " + nameMethod  + " & Số lần mượn sách là  : "+ ++borrowBook );
        }else if (nameMethod.equals("giveBookBack")){
            logger.info( "Tên Phương thức : " + nameMethod  + " & Số lần trả sách là  : "+ ++giveBackBook );
        }else{
            logger.info( "Tên Phương thức : " + nameMethod  + " & Số người ghé qua là   : "+ ++client);
        }

    }

//    @AfterThrowing("execution(* librarybook.borrowbooks.controller.BookController.*(..))")
//    public  void logAfterMethod(JoinPoint joinPoint){
//        String nameMethod = joinPoint.getSignature().getName();
//        logger.info("tên phương thức " + nameMethod );
//    }
//    @Before("execution(* librarybook.borrowbooks.controller.BookController.borrow(..))")
////    public  void logBeforeMethod(JoinPoint joinPoint){
////        String nameMethod = joinPoint.getSignature().getName();
////        logger.info("tên phương thức  " + nameMethod  + "muon sach");
////    }
//    @Around("execution(* librarybook.borrowbooks.controller.BookController.*(..))")
//    public  void logAfterMethod(JoinPoint joinPoint){
//        String nameMethod = joinPoint.getSignature().getName();
//        logger.info("tên phương thức " + nameMethod );
//    }
}
