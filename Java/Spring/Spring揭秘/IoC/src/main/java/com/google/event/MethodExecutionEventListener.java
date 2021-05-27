package com.google.event;

import java.util.EventListener;

public interface MethodExecutionEventListener extends EventListener {
    void onMethodBegin(MethodExecutionEvent event);

    void onMethodEnd(MethodExecutionEvent event);
}
