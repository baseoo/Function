package org.example.thread;

import java.util.concurrent.*;

public class ThreadMain {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ArrayBlockingQueue fairQueue = new ArrayBlockingQueue(1000, true);
    }
}
