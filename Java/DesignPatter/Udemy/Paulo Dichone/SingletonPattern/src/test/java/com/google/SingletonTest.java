package com.google;

import org.junit.jupiter.api.Test;

public class SingletonTest {
    @Test
    public void testSingleton() {
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println();

        Person person = new Person();
        Person person2 = new Person();
        System.out.println(person);
        System.out.println(person2);
    }
}
