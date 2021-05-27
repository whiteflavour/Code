package com.google.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class ApplicationMethodPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public void methodToMonitor() {
        ApplicationMethodEvent beginEvent = new ApplicationMethodEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
        applicationEventPublisher.publishEvent(beginEvent);

        System.out.println("fuck");
        System.out.println("qnmd");
        System.out.println("cao");
        System.out.println("worinima");

        ApplicationMethodEvent endEvent = new ApplicationMethodEvent(this, "methodToMonitor", MethodExecutionStatus.END);
        applicationEventPublisher.publishEvent(endEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
