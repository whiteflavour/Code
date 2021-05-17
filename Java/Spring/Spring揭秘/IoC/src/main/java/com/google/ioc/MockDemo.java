package com.google.ioc;

import java.util.Map;

public class MockDemo {
    private Map<Integer, Integer> map;

    public MockDemo() {
    }

    public MockDemo(Map<Integer, Integer> map) {
        this.map = map;
    }

    public Map<Integer, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Integer> map) {
        this.map = map;
    }
}
