package com.google.custom_scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class ThreadScope implements Scope {
    private final ThreadLocal threadScope = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        Map scope = (Map) threadScope.get();
        Object object = scope.get(s);

        if (object == null) {
            object = objectFactory.getObject();
            scope.put(s, object);
        }

        return object;
    }

    @Override
    public Object remove(String s) {
        Map scope = (Map) threadScope.get();

        return scope.remove(s);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
