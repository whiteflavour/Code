package com.google.event;

import org.springframework.context.ApplicationListener;

public class ApplicationMethodListener implements ApplicationListener<ApplicationMethodEvent> {
    @Override
    public void onApplicationEvent(ApplicationMethodEvent applicationMethodEvent) {
        System.out.println("method [" + applicationMethodEvent.getMethodName() + "] on status: " + applicationMethodEvent.getStatus());
    }
}
