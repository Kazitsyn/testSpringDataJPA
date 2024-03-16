package com.example.testSpringDataJPA.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserActionAspect {

    @Before("@annotation(com.example.testSpringDataJPA.aspect.TrackUserAction)")
    public void trackUserAction(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String user = "localhost"; // логика определения пользователя
        System.out.println("User: " + user + " Action: " + methodName + " Args: " + args.toString());
    }
}