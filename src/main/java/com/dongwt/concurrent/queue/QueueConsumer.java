package com.dongwt.concurrent.queue;

import java.util.concurrent.BlockingQueue;

import com.alibaba.fastjson.JSONObject;
import com.dongwt.concurrent.model.User;

public class QueueConsumer implements Runnable {

    private BlockingQueue<User> queue;

    public QueueConsumer() {
    }

    public QueueConsumer(BlockingQueue<User> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean flag = true;

        while (flag) {
            try {
                User user = queue.take();
                System.out.println("Consumer\r\n" + JSONObject.toJSONString(user));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
