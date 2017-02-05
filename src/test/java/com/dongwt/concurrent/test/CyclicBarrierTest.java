package com.dongwt.concurrent.test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dongwt.concurrent.model.Barrier;

public class CyclicBarrierTest {
    
    public static void main(String[] args){
        
        int count = 50;
        
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        
        CyclicBarrier cyclic = new CyclicBarrier(count);
        
        for(int i=0 ; i<count ; i++){
            Runnable barrier = new Barrier(cyclic);
            executorService.submit(barrier);
        }
      
        
        System.out.println("over");
    }

}
