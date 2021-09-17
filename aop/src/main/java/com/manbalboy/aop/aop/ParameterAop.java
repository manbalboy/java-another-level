package com.manbalboy.aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAop {


    //표현식 인터넷..
    @Pointcut("execution(* com.manbalboy.aop.controller..*.*(..))")
    private void cut() {
    }


    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();


        for (Object obj : args) {
            System.out.println("type  : " + obj.getClass().getSimpleName());
        }

    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("returnObj  >" + returnObj);
    }

}
