package org.example.aqs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AqsMain {

    public static void main(String[] args) {
        Goods goods = new Goods();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    goods.reduceCount();
                }
            }).start();
        }
    }

    private static class Goods {
        private int count = 10;
        private MyAQS lock = new MyAQS();

        public void reduceCount() {
            lock.lock();

            if (count > 0) {
                System.out.println("线程" + lock.getLockHoder() + "获取第" + count + "件商品");
                count--;
            } else {
                System.out.println("商品已卖完");
            }

            lock.unlock();
        }
    }

}
