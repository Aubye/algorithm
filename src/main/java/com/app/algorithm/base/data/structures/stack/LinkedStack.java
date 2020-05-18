package org.learning.base.data.structures.stack;

import org.learning.base.data.structures.link.LinkedNode;

public class LinkedStack<T> implements Stack<T> {

    private LinkedNode<T> stack = new LinkedNode<>();

    @Override
    public void push(T t) {
        stack = new LinkedNode<>(t, stack);
    }

    @Override
    public T pop() {
        LinkedNode<T> next = stack.getNext();
        if (next == null) {
            return null;
        }
        T data = stack.getData();
        stack.setNext(null);
        stack = next;
        return data;
    }

    @Override
    public T peek() {
        return stack.getNext() == null ? null : stack.getData();
    }
}
