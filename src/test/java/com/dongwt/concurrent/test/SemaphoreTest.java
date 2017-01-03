package com.dongwt.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(50,true);

        for (int i = 0; i < 50; i++) {

            final Integer NO = i;

            Runnable runnable = new Runnable() {

                @Override
                public void run() {

                    try {
                        semaphore.acquire();
                        System.out.println("acquire:" + NO);
                        Thread.sleep(1000);
                        semaphore.release();
//                        System.out.println("-----------------" + semaphore.availablePermits());
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };

            executor.execute(runnable);
        }

        executor.shutdown();

    }

}
