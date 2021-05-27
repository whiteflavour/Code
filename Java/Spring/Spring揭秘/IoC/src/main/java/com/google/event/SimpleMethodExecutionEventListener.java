package com.google.event;

public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {
    @Override
    public void onMethodBegin(MethodExecutionEvent event) {
        String methodName = event.getMethodName();
        System.out.println("Started method [" + methodName + "] ... ");
    }

    @Override
    public void onMethodEnd(MethodExecutionEvent event) {
        String methodName = event.getMethodName();
        System.out.println("Finished method [" + methodName + "] ... ");
    }
}
