package com.app.algorithm.base.data.structures.stack;

import com.app.algorithm.base.data.structures.queue.Queue;

public class CircularQueue<T> implements Queue<T> {

    private static final int DEFAULT_SIZE = 2 << 3;

    private Object[] queue;
    private int header = 0;
    private int tail = 0;

    public CircularQueue() {
        queue = new Object[DEFAULT_SIZE];
    }

    public CircularQueue(int size) {
        queue = new Object[size];
    }

    @Override
    public boolean enqueue(T t) {
        if (isFull()) {
            return false;
        }
        queue[tail] = t;
        tail = (tail + 1) % queue.length;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = (T) queue[tail];
        header = (header + 1) % queue.length;
        return data;
    }

    private boolean isEmpty() {
        return header == tail;
    }

    private boolean isFull() {
        //tail=3，head=4，size=8 时队列已满 (3+1) % 8=4
        return (tail + 1) % queue.length == header;
    }

}
