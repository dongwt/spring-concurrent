package com.dongwt.concurrent.test;

public class InterruptTest {
    
    
    private static class MyRunnable implements Runnable{

        @Override
        public void run() {

            while(true){
                System.out.println("haha");
                try {
                    Thread.currentThread().isInterrupted();
                    Thread.currentThread().interrupted();
                    Thread.currentThread().isInterrupted();
//                    Thread.sleep(10000);
                }
                catch (Exception e) {
                    System.out.println("MyRunnable");
                    System.out.println("interrupt" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
            
        }
        
    }
    
    
    
    public static void main(String[] args){
        
        Thread thread1 = new Thread(new MyRunnable());
        
        System.out.println("begin...");
        
        thread1.start();
        
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            System.out.println("main");
            e.printStackTrace();
        }
        
        while(true){
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//            thread1.interrupt();
        }
       
    }

}
