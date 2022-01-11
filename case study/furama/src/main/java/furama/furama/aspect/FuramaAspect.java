package furama.furama.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FuramaAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* furama.furama.controller.CustomerController.*(..))")
    public void logAfterMethodCustomer(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("tên phương thức Customer " + nameMethod);
    }
    @After("execution(* furama.furama.controller.EmployeeController.*(..))")
    public void logAfterMethodEmployee(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("tên phương thức  Employee " + nameMethod);
    }
    @After("execution(* furama.furama.controller.ContractController.*(..))")
    public void logAfterMethodContract(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("tên phương thức  Contract " + nameMethod);
    }
    @After("execution(* furama.furama.controller.ServiceResortController.*(..))")
    public void logAfterMethodServiceResort(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("tên phương thức  ServiceResort " + nameMethod);
    }
}
