package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsPalindrome {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-121);
        log.info("isPalindrome:{}", palindrome);
    }

    public static boolean isPalindrome(int x) {
        long y = 0;
        int target = x;
        while (target != 0) {
            y = y * 10 + target % 10;
            target = target / 10;
        }
        return (int) y == x;
    }

}
