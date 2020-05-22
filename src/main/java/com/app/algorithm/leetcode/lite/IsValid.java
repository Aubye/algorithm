package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class IsValid {

    public static void main(String[] args) {
        boolean valid = isValid("([]){}");
        log.info("valid:{}", valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char character : charArray) {
            if (stack.size() == 0) {
                stack.push(character);
            } else if (compare(stack.peek(), character)) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }
        return stack.size() == 0;
    }

    private static boolean compare(char a, char b) {
        return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
    }

}
