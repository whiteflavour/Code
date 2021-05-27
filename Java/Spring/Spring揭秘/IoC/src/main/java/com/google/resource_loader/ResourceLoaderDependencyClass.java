package com.google.resource_loader;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ResourceLoader;

public class ResourceLoaderDependencyClass implements ApplicationContextAware {
    private ResourceLoader resourceLoader;

    public void showClass(String location) {
        System.out.println(getResourceLoader().getResource(location).getClass());
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.resourceLoader = applicationContext;
    }
}
