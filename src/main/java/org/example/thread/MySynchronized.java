package org.example.thread;

/**
 * 锁升级：无锁，偏向锁，轻量级锁，重量级锁
 * 概念，升级过程
 */
public class MySynchronized {


    /**
     * 普通方法
     * ACC_SYNCHRONIZED
     */
    public synchronized void doSth() {
        System.out.println("Hello World");
    }

    /**
     * 同步代码块
     * monitorenter
     * monitorexit
     */
    public void doSth1() {
        synchronized (MySynchronized.class) {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        new MySynchronized().doSth();
    }
}
