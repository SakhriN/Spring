package net.example.exo_aspect.aspect;

import net.example.exo_aspect.utils.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class PerformanceAspect {

    private long startTime;

    @Pointcut("execution(* net.example.exo_aspect.service.BookService.*(..))")
    public void libraryServiceMethods() {}

    @Before("libraryServiceMethods()")
    public void beforeLibraryServiceMethod() {
        startTime = System.currentTimeMillis();
    }

    @After("libraryServiceMethods()")
    public void afterLibraryServiceMethod(JoinPoint joinPoint) {
        long executionTime = System.currentTimeMillis() - startTime;
        Logger.log("Execution time of method " + joinPoint.getSignature().getName() + ": " + executionTime + " milliseconds");
    }
}
