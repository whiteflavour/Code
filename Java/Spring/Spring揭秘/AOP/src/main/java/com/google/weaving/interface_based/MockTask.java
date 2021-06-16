package com.google.weaving.interface_based;

public class MockTask implements ITask {
    @Override
    public void execute() {
        System.out.println("task executed ... ");
    }
}
