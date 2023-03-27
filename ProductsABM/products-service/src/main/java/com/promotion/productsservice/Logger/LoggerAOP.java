package com.promotion.productsservice.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAOP {

    private static final Logger logger = LogManager.getLogger(LoggerAOP.class);


//    @Before("execution(* com.promotion.productsservice.Controller.ProductController.*(..))")
    public void beforeExecution(JoinPoint joinPoint){
        logger.info("Log antes de la ejecucion: {}", joinPoint.getSignature().getName());
    }

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void log_every_get_method(JoinPoint joinPoint){
        logger.info("Log antes del GET: {}", joinPoint.getSignature());
    }

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void log_every_POST_method(JoinPoint joinPoint){
        logger.info("POST Method: {}\n args:{}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }


}
