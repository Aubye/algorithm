package com.app.algorithm.base.data.structures.stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {

    /**
     * 初始容量为8
     */
    private static final int DEFAULT_SIZE = 2 << 2;

    private Object[] stack;

    private int count = 0;

    public ArrayStack() {
        stack = new Object[DEFAULT_SIZE];
    }

    public ArrayStack(int capacity) {
        stack = new Object[capacity];
    }

    @Override
    public void push(T t) {
        if (count >= stack.length) {
            grow();
        }
        stack[count++] = t;
    }

    private void grow() {
        int oldStackCapacity = stack.length;
        int newStackCapacity = oldStackCapacity + (oldStackCapacity >> 1);
        stack = Arrays.copyOf(stack, newStackCapacity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (count > 0) {
            T obj = (T) stack[--count];
            stack[count] = null;
            return obj;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        return count > 0 ? (T) stack[count - 1] : null;
    }
}
