package com.dongwt.concurrent.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.dongwt.concurrent.lock.ArrayBlockingQueue;
import com.dongwt.concurrent.model.User;
import com.dongwt.concurrent.queue.QueueConsumer;
import com.dongwt.concurrent.queue.QueueProvider;

public class ConditionTest {
    
    public static void main(String[] args){
        
        BlockingQueue<User> queue = new ArrayBlockingQueue<User>(10);

        Runnable queueProvider = new QueueProvider(queue);

        Runnable queueConsumer = new QueueConsumer(queue);

        Executor executorProvider = Executors.newFixedThreadPool(5);

        executorProvider.execute(queueProvider);

        Executor executorConsumer = Executors.newFixedThreadPool(5);

        executorConsumer.execute(queueConsumer);
        
    }

}
