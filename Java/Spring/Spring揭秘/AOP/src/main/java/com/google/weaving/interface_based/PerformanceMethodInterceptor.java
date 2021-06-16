package com.google.weaving.interface_based;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class PerformanceMethodInterceptor implements MethodInterceptor {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            return invocation.proceed();
        } finally {
            stopWatch.stop();
            if (logger.isInfoEnabled()) {
                logger.info(stopWatch.toString());
            }
        }
    }
}
