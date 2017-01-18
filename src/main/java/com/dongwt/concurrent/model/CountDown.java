package com.dongwt.concurrent.model;

import java.util.concurrent.CountDownLatch;

public class CountDown implements Runnable {
    
    private CountDownLatch countDownLatch;
    
    public CountDown(){}
    
    public CountDown(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("doing...");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }

}
