package org.learning.base.data.structures.queue;

public interface Queue<T> {

    boolean enqueue(T t);

    T dequeue();

}
