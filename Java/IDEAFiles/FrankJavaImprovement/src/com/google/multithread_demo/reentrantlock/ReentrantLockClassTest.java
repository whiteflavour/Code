package com.google.multithread_demo.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A class that the thread is locked by the Lock Class.
 * @author Frank, Liao
 * @date 2020-10-31
 */
public class ReentrantLockClassTest implements Runnable {
    private int shoeNumber = 10;

    // 不建议使用，随着 JDK 版本的更新，synchronized 的效率还是挺高的。还是要看应用场景，能用 synchronized 解决就用 synchronized 。因为 Lock 锁比较自由，就伴随一定的风险。
    Lock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            reentrantLock.lock();
            try {
                if (shoeNumber > 0) {
                    Thread.sleep(500);
                    System.out.println("恭喜 \"" + Thread.currentThread().getName() + "\" 抢到了第" + (shoeNumber--) + "双鞋");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
