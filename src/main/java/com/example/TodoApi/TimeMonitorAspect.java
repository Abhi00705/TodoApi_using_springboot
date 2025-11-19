package com.example.TodoApi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {
    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint joinPoint){
       Long start=System.currentTimeMillis();
        try{
            joinPoint.proceed();
        }  catch (Throwable e) {
            System.out.println("Something went wrong");
        } finally {
            Long end=System.currentTimeMillis();
            System.out.println("total time of execution: "+ (end - start)+"ms");
        }


    }


}
