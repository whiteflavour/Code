package com.google.after_advice.after_throwing;

public class DivideZeroClass {
    /**
     * <b>note：</b>异常不能用 try/catch 包起来，
     * 否则就直接被 catch 捕获了，而 Aspect 则捕获不到
     */
    public void operate() {
        int num = 5 / 0;
    }
}
