package org.example.thread;

/**
 * 两个线程交替打印数字
 */
public class ThreadPrint implements Runnable {

    private String name;
    private static Object object = new Object();
    private static int i = 0;

    public ThreadPrint(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (i < 20) {
            synchronized (object) {
                System.out.println(this.name + ":" + i);
                try {
                    Thread.sleep(100);
                    i++;
                    object.notifyAll();
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadPrint("线程1"));
        Thread thread2 = new Thread(new ThreadPrint("线程2"));

        thread1.start();
        thread2.start();
    }
}
