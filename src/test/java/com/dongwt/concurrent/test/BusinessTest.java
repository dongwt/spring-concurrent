package com.dongwt.concurrent.test;

import com.dongwt.concurrent.lock.Business;

public class BusinessTest {

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (1 == 1) {
                        Business.handleA();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (1 == 1) {
                        Business.handleB();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (1 == 1) {
                        Business.handleC();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }

}
