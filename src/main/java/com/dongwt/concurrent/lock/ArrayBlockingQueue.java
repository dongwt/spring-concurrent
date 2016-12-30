package com.dongwt.concurrent.lock;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Function: 阻塞队列
 *
 * @author   dongwt
 * @Date	 2016年12月30日		下午2:52:09
 *
 * @see 	 @param <E>
 */
public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private final ReentrantLock lock;

    private final Condition notEmpty;

    private final Condition notFull;

    private final Object[] items;

    private int count;

    private int takeIndex;

    private int putIndex;

    public ArrayBlockingQueue(int capacity) {
        items = new Object[capacity];
        lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put(E e) throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putIndex] = e;
            if (++putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            notEmpty.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while (0 == count) {
                notEmpty.await();
            }
            @SuppressWarnings("unchecked")
            E item = (E) items[takeIndex];
            items[takeIndex] = null;

            if (++takeIndex == items.length) {
                takeIndex = 0;
            }

            count--;
            notFull.signalAll();
            return item;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean offer(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int remainingCapacity() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
