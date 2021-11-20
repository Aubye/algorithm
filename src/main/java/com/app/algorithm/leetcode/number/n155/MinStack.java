package com.app.algorithm.leetcode.number.n155;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

@Slf4j
@Data
public class MinStack {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * push(x) —— 将元素 x 推入栈中。
     * pop()—— 删除栈顶的元素。
     * top()—— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        for (int i = 0; i < 5; i++) {
            minStack.push(i + 1);
        }
        int top = minStack.top();
        int min = minStack.getMin();
        log.info("minStack:{}, top:{}, min:{}", minStack, top, min);
    }

    Deque<Integer> stack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */