package com.google.factory_method;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class NextDayDateFactoryBean implements FactoryBean<Integer> {
    @Override
    public Integer getObject() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
