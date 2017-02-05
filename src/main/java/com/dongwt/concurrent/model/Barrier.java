package com.dongwt.concurrent.model;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import lombok.Data;

@Data
public class Barrier implements Runnable{
    
    private CyclicBarrier cyclicBarrier;
    
    public Barrier(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "我已到达.");
            cyclicBarrier.await();
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "继续走.");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
