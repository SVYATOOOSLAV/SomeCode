package edu.LockQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockQueue<T> {
    private final Queue<T> queue = new ArrayDeque<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private final int capacity;

    public LockQueue(int capacity){
        this.capacity = capacity;
    }

    public void push(T e) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() == capacity){
                notFull.await();
            }
            queue.add(e);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T poll() throws InterruptedException {
        lock.lock();
        try{
            while(queue.isEmpty()){
                notEmpty.await();
            }
            return queue.poll();
        } finally {
            notFull.signalAll();
            lock.unlock();
        }
    }
}
