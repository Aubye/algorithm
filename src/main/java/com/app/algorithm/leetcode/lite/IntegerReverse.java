package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerReverse {

    public static void main(String[] args) {
        int reverse = reverse(Integer.MAX_VALUE);
        log.info("reverse:{}", reverse);
    }

    // 1234 -> [1,2,3,4] -> foreach to /10 right
    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

}
