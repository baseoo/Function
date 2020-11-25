package org.example.aqs;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class MyAQS {

    // 当前锁的状态，1表示加锁，0表示未加锁
    private volatile int state = 0;
    // Unsafe
    private static Unsafe unsafe =  null;
    private static long stateOffset = 0;
    // 当前持有锁的线程
    private Thread lockHoder;
    // 线程安全的队列，记录等待获取锁的线程
    private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<>();

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            stateOffset = unsafe.objectFieldOffset(MyAQS.class.getDeclaredField("state"));
        } catch (Exception e) {
            log.error("exception:" + e);
        }
    }

    /**
     * 获取锁
     */
    public void lock() {
        if (acquire()) {
            return;
        }
        Thread current = Thread.currentThread();
        waiters.add((current));
        for (;;) {
            if (current == waiters.peek() && acquire()) {//peek：返回队列头部的元素，如果队列为空，则返回null
                waiters.poll();//poll：移除并返回队列头部的元素，如果队列为空，则返回null
                return;
            }
            LockSupport.park();
        }
    }

    /**
     * 释放锁
     */
    public void unlock() {
        if (Thread.currentThread() != getLockHoder()) {
            throw new RuntimeException("lockHolder is not current Thread");
        }
        int state = getState();
        if (compareAndSwapInt(state, 0)) {
            setLockHoder(null);
            Thread t = waiters.peek();
            if (t != null) {
                LockSupport.unpark(t);
            }
        }
    }

    private boolean acquire() {
        Thread t = Thread.currentThread();
        if ((waiters.size() == 0 || t == waiters.peek()) && compareAndSwapInt(0, 1)) {
            setLockHoder(t);
            return true;
        }
        return false;
    }

    private boolean compareAndSwapInt(int i, int i1) {
        if (unsafe.compareAndSwapInt(MyAQS.class, stateOffset, i, i1)) {
            setState(i1);
            return true;
        }
        return false;
    }

    public Thread getLockHoder() {
        return lockHoder;
    }

    public void setLockHoder(Thread lockHoder) {
        this.lockHoder = lockHoder;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
