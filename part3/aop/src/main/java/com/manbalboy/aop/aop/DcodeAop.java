package com.manbalboy.aop.aop;


import com.manbalboy.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DcodeAop {

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof User user) {
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), StandardCharsets.UTF_8);
                user.setEmail(email);
            }
        }

    }


    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void after(JoinPoint joinPoint, Object returnObj) {

    }

    //표현식 인터넷..
    @Pointcut("execution(* com.manbalboy.aop.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("@annotation(com.manbalboy.aop.annotaion.Timer)")
    private void enableDecode() {
    }
}
