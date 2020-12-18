package org.example.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两个线程交替打印数字（volatile,AtomicInteger）
 */
@Slf4j
public class PrintABVolatile {
    private static final int MAX_PRINT_NUM = 100;
    private static volatile int count = 0;
    private static AtomicInteger count2 = new AtomicInteger(0);

    public void printAB() {
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    log.info("num:" + count);
                    count++;
                }
            }
        }).start();
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    log.info("num:" + count);
                    count++;
                }
            }
        }).start();
    }

    public void printAB2() {
        new Thread(() -> {
            while (count2.get() < MAX_PRINT_NUM) {
                if (count2.get() % 2 == 0) {
                    log.info(Thread.currentThread().getName() + ",num:" + count2);
                    count2.getAndIncrement();
                }
            }
        }).start();
        new Thread(() -> {
            while (count2.get() < MAX_PRINT_NUM) {
                if (count2.get() % 2 == 1) {
                    log.info(Thread.currentThread().getName() + ",num:" + count2);
                    count2.getAndIncrement();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new PrintABVolatile().printAB2();
    }
}