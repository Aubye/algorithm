package com.app.algorithm.leetcode.number.n232;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class MyQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 5; i++) {
            myQueue.push(i + 1);
        }
        int peek = myQueue.peek();
        while (!myQueue.empty()) {
            log.info("myQueue pop:{}", myQueue.pop());
        }
    }

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */