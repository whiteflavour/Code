package com.google.custom_scopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

public class ScopeRegister {
    private ThreadScope threadScope = new ThreadScope();

    public void scopeRegistration(ConfigurableBeanFactory beanFactory) {
        beanFactory.registerScope("thread", threadScope);
    }
}
