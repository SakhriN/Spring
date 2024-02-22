package net.example.exo_aspect.aspect;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;

@Aspect
public class PerformanceAspect {

    private long startTime;
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Pointcut("execution(* net.example.exo_aspect.service.BookService.*(..))")
    public void libraryServiceMethods() {}


    @Around("libraryServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        logger.info("Method " + joinPoint.getSignature().getName() + " executed in " + executionTime + " milliseconds");

        return result;
    }
}
