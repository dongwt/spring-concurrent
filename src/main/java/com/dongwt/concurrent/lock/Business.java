package com.dongwt.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Business {

    private static String type = "A";

    private static Lock lock = new ReentrantLock();

    private static Condition conditionA = lock.newCondition();

    private static Condition conditionB = lock.newCondition();

    private static Condition conditionC = lock.newCondition();

    public static void handleA() throws InterruptedException {
        lock.lock();
        try {
            while (!"A".equals(type))
                conditionA.await();
            System.out.println("A");
            type = "B";
            conditionB.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public static void handleB() throws InterruptedException {
        lock.lock();
        try {
            while (!"B".equals(type))
                conditionB.await();
            System.out.println("B");
            type = "C";
            conditionC.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public static void handleC() throws InterruptedException {
        lock.lock();
        try {
            while (!"C".equals(type))
                conditionC.await();
            System.out.println("C\t\n");
            type = "A";
            conditionA.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

}
