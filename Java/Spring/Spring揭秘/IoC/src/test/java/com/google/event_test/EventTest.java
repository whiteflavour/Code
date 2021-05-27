package com.google.event_test;

import com.google.event.MethodExecutionEventPublisher;
import com.google.event.SimpleMethodExecutionEventListener;
import org.junit.Test;

public class EventTest {
    @Test
    public void methodExecutionEventTest() {
        MethodExecutionEventPublisher publisher = new MethodExecutionEventPublisher();
        publisher.addMethodExecutionEventListener(new SimpleMethodExecutionEventListener());
        publisher.methodToMonitor();
    }
}
