package com.example.mod2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LibraryAspect {
    @Pointcut("execution(public void get* ())")
    public void allGetMethods() {

    }

    @Pointcut("execution(public void return*())")
    public void allReturnMethods() {

    }

    @Before("allGetMethods() || allReturnMethods())")
    public void getAdvice(JoinPoint joinPoint) {

        System.out.printf("LOG:%s Операция с книгой", joinPoint.getSignature().getName());
    }

    @Around("execution(public void add*(String))")
    public void addAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder info = new StringBuilder(String.format("%s args: ", joinPoint.getSignature().getName()));
        for (var arg : joinPoint.getArgs()) {
            info.append((String) arg);
            info.append(" ");
        }
        try {
            System.out.println("LOG:Начало метода "+ info);
            joinPoint.proceed();
            System.out.println("LOG:Добавил автора");
            System.out.println("LOG:Метод выполнен успешно "+ info);
        } catch (Exception e) {
            System.out.println("LOG:Возникла ошибка! "+e.getMessage() +" "+ info);
            throw e;
        }
    }
}
