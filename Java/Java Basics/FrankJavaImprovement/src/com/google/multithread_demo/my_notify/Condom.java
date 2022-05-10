package com.google.multithread_demo.my_notify;

/**
 * Condoms to grab.
 * @author Liao, Frank
 * @date 2020-11-16
 */
public class Condom {
    private static boolean isHaving = false;

    public Condom() {}
    public Condom(boolean isHaving) {
        this.isHaving = isHaving;
    }
    public boolean getHaving() {
        return this.isHaving;
    }
    public void setHaving(boolean isHaving) {
        this.isHaving = isHaving;
    }
}
