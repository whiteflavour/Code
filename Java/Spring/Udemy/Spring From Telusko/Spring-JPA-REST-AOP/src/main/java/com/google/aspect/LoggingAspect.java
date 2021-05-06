package com.google.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.google.controller.AlienController.getAliens())")
    public void logBefore() {
        LOGGER.info("getAliens method called from aspect ... ");
    }

    @AfterReturning("execution(public * com.google.controller.AlienController.getAliens())")
    public void logReturning() {
        LOGGER.info("getAliens method called after returning ... ");
    }

    @AfterThrowing("execution(public * com.google.controller.AlienController.getAliens())")
    public void logThrowing() {
        LOGGER.info("getAliens method called after throwing ... ");
    }
}
