package com.google.introduction;

public class MockTask implements ITask {
    @Override
    public void execute() {
        System.out.println("task executing...");
    }
}
