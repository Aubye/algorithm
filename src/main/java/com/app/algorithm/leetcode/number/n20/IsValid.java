package com.app.algorithm.leetcode.number.n20;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Slf4j
public class IsValid {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */
    public static void main(String[] args) {
        String str = "[()]";
        boolean result = isValid(str);
        log.info("result:{}", result);
    }

    static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char val = chars[i];
            if (pairs.containsKey(val)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(val)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(val);
            }
        }
        return stack.isEmpty();
    }

}
