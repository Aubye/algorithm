package com.app.algorithm.base.data.structures.stack;

import com.app.algorithm.base.data.structures.link.LinkedNode;
import com.app.algorithm.base.data.structures.queue.Queue;

public class LinkedQueue<T> implements Queue<T> {

    private LinkedNode<T> header;

    private LinkedNode<T> tail;

    @Override
    public boolean enqueue(T t) {
        LinkedNode<T> node = new LinkedNode<>(t, null);
        if (header == null) {
            header = node;
            tail = node;
            return true;
        }
        tail.setNext(node);
        tail = node;
        return true;
    }

    @Override
    public T dequeue() {
        if (tail == null) {
            return null;
        }
        T data = header.getData();
        LinkedNode<T> next = header.getNext();
        header.setNext(null);
        header = next;
        return data;
    }
}
