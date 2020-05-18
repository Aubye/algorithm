package org.learning.base.data.structures.queue;

public class ArrayQueue<T> implements Queue<T> {

    /** 初始容量为16 */
    private static final int DEFAULT_SIZE = 2 << 3;

    private Object[] queue;

    private int header = 0;

    private int tail = 0;

    public ArrayQueue() {
        queue = new Object[DEFAULT_SIZE];
    }

    public ArrayQueue(int capacity) {
        queue = new Object[capacity];
    }

    @Override
    public boolean enqueue(T t) {
        if (tail >= queue.length) {
            if (header == 0) {
                return false;
            } else {
                move();
            }
        }
        queue[tail++] = t;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if (header >= tail) {
            return null;
        }
        T obj = (T) queue[header];
        queue[header] = null;
        header++;
        return obj;
    }

    private void move() {
        for (int i = 0; i < tail - header; i++) {
            queue[i] = queue[header + i];
            queue[header + i] = null;
        }
        tail = tail - header;
        header = 0;
    }
}
