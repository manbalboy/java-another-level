package com.manbalboy.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    //표현식 인터넷..
    @Pointcut("execution(* com.manbalboy.aop.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("@annotation(com.manbalboy.aop.annotaion.Timer)")
    private void enableTimer() {
    }

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        stopWatch.stop();

        System.out.println("total time  ::: " + stopWatch.getTotalTimeSeconds());

    }
}
