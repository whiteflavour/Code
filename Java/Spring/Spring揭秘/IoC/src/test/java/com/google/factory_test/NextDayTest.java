package com.google.factory_test;

import org.junit.Test;

import java.util.Calendar;

public class NextDayTest {
    @Test
    public void nextDayTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

}
