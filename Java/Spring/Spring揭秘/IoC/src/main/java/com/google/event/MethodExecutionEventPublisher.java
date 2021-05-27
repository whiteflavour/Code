package com.google.event;

import java.util.ArrayList;
import java.util.List;

public class MethodExecutionEventPublisher {
    private List<MethodExecutionEventListener> listeners = new ArrayList<>();

    public void methodToMonitor() {
        MethodExecutionEvent event = new MethodExecutionEvent(this, "methodToMonitor");
        publishEvent(MethodExecutionStatus.BEGIN, event);
        System.out.println("Hello, world!");
        System.out.println("qnmd");
        System.out.println("fuck");
        System.out.println("cao");
        publishEvent(MethodExecutionStatus.END, event);
    }

    protected void publishEvent(MethodExecutionStatus status, MethodExecutionEvent event) {
        List<MethodExecutionEventListener> copyListeners = new ArrayList<>(listeners);
        for (MethodExecutionEventListener listener : copyListeners) {
            if (status.equals(MethodExecutionStatus.BEGIN)) {
                listener.onMethodBegin(event);
            } else {
                listener.onMethodEnd(event);
            }
        }
    }

    public void addMethodExecutionEventListener(MethodExecutionEventListener listener) {
        listeners.add(listener);
    }

    public void removeMethodExecutionEventListener(MethodExecutionEventListener listener) {
        listeners.remove(listener);
    }

    public void removeAllMethodExecutionEventListener() {
        listeners.clear();
    }
}
