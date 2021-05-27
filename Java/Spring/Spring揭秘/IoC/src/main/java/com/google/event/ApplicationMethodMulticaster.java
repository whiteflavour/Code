package com.google.event;

import org.springframework.context.event.ApplicationEventMulticaster;

public class ApplicationMethodMulticaster {
    private ApplicationEventMulticaster eventMulticaster;

    public ApplicationMethodMulticaster() {
    }

    public ApplicationMethodMulticaster(ApplicationEventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }

    public ApplicationEventMulticaster getEventMulticaster() {
        return eventMulticaster;
    }

    public void setEventMulticaster(ApplicationEventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }

    public void methodToMonitor() {
        eventMulticaster.addApplicationListenerBean("applicationMethodListener");
        ApplicationMethodEvent beginEvent = new ApplicationMethodEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
        eventMulticaster.multicastEvent(beginEvent);

        System.out.println("fuck");
        System.out.println("qnmd");
        System.out.println("cao");
        System.out.println("worinima");

        ApplicationMethodEvent endEvent = new ApplicationMethodEvent(this, "methodToMonitor", MethodExecutionStatus.END);
        eventMulticaster.multicastEvent(endEvent);
    }
}
