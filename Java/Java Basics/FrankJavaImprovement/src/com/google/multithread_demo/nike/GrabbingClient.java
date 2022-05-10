package com.google.multithread_demo.nike;

/**
 * Some people to grab some nike shoes.
 * @author Liao, Frank
 * @date 2020.10.29
 */
public class GrabbingClient implements Runnable {
    private int shoeNumber = 100;

    @Override
    public void run() {
        while (shoeNumber > 0) {
            System.out.println("恭喜 \"" + Thread.currentThread().getName() + "\" 抢到了第" + (shoeNumber--) + "双鞋");
        }
    }
}
