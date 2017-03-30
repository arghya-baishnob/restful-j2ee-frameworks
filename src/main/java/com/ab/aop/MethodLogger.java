package com.ab.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class MethodLogger {

    @Pointcut("execution(* com.ab.service.*.*.*(..))")
    public void serviceMethod() {}

    @Pointcut("execution(* com.ab.dao.*.*.*(..))")
    public void daoMethod() {}

   /* @Pointcut("execution(* com.ab.web.action.*.*(..))")
    public void actionMethod() {}*/

    @Before("com.ab.aop.MethodLogger.serviceMethod() || com.ab.aop.MethodLogger.daoMethod()")
    public void logMethodStart(final JoinPoint jp) {
        final Logger logger = Logger.getLogger(jp.getSignature().getDeclaringType());
        logger.info("Entering " + jp.getSignature().getName() + "()"); // can commit this line
        if (logger.isDebugEnabled()) {
            logger.debug("Entering " + jp.getSignature().getName() + "()");
        }
    }

    @After("com.ab.aop.MethodLogger.serviceMethod() || com.ab.aop.MethodLogger.daoMethod()")
    public void logMethodEnd(final JoinPoint jp) {
        final Logger logger = Logger.getLogger(jp.getSignature().getDeclaringType());
        logger.info("Exiting " + jp.getSignature().getName() + "()"); // can commit this line
        if (logger.isDebugEnabled()) {
            logger.debug("Exiting " + jp.getSignature().getName() + "()");
        }
    }
}
