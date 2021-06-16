package com.google.pointcut.control_flow_pointcut;

public class TargetCaller {
    private TargetObject target;

    public void callMethod() {
        target.method1();
    }

    public void setTarget(TargetObject target) {
        this.target = target;
    }
}
