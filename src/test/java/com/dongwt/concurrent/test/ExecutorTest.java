package com.dongwt.concurrent.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    
    public static void main(String[] args){
        
        int count = 10;
        
        ExecutorService service = Executors.newFixedThreadPool(count);
        
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        
        for(int i=0; i<count; i++){
            Callable<String> callable = new Callable<String>(){
                @Override
                public String call() throws Exception {
                    return new Random().nextInt(10) + "";
                }
            };
            Future<String> future = service.submit(callable);
            futureList.add(future);
        }
        
        service.shutdown();
        
        
        while(true){
            if(service.isShutdown()){
                break;
            }
        }
        
        for(Future<String> item : futureList){
            try {
                System.out.println(item.get());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        
        
    }

}
