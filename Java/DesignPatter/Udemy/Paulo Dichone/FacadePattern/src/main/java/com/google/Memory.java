package com.google;

import java.util.Arrays;

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Loaded data: " + Arrays.toString(data) + ", from: " + position);
    }
}
