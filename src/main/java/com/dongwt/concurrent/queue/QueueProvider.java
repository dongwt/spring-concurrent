package com.dongwt.concurrent.queue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

import com.dongwt.concurrent.model.User;

public class QueueProvider implements Runnable {

    private BlockingQueue<User> queue;

    public QueueProvider() {
    }

    public QueueProvider(BlockingQueue<User> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        boolean flag = true;

        while (flag) {
            String uuid = UUID.randomUUID().toString();
            try {
                User user = new User(uuid, uuid);
                Thread.sleep(1000);
                queue.put(user);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
