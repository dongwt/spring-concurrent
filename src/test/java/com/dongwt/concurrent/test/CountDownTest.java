package com.dongwt.concurrent.test;

import java.util.concurrent.CountDownLatch;

import com.dongwt.concurrent.model.CountDown;

public class CountDownTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        Runnable runnable = new CountDown(countDownLatch);

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        try {
            System.out.println("await...");
            countDownLatch.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("end");
        }

    }

}
