package com.google.ioc;

public class ObjectContainer {
    private Object object;

    private ObjectContainer() {}

    public static ObjectContainer getInstance() {
        return new ObjectContainer();
    }
    public ObjectContainer(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
