package com.google.event;

import org.springframework.context.ApplicationEvent;

public class ApplicationMethodEvent extends ApplicationEvent {
    private static final long serialVersionUID = 42L;
    private String methodName;
    private MethodExecutionStatus status;

    public ApplicationMethodEvent(Object source) {
        super(source);
    }

    public ApplicationMethodEvent(Object source, String methodName, MethodExecutionStatus status) {
        super(source);
        this.methodName = methodName;
        this.status = status;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(MethodExecutionStatus status) {
        this.status = status;
    }
}
