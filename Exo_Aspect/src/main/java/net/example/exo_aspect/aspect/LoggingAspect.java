package net.example.exo_aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* net.example.exo_aspect.service.BookService.*(..))")
    public void libraryServiceMethods() {}

    @Around("libraryServiceMethods()")
    public Object logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Entering method: " + joinPoint.getSignature().getName());
        logger.info("Arguments: " + joinPoint.getArgs());
        Object object = joinPoint.proceed();
        logger.info("Exiting method: ");
        return object;
    }

}
