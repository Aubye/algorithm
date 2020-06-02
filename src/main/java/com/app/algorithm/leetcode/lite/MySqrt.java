package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySqrt {

    public static void main(String[] args) {
        int number = 2147395599;
        double sqrt = Math.sqrt(number);
        int result = mySqrt(number);
        log.info("sqrt:{}, result:{}", sqrt, result);
    }

    private static int mySqrt(int x) {
        if (x == 1) {
            return x;
        }
        long left = 0;
        long right = x / 2;
        int ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = mid * mid;
            if (temp <= x) {
                ans = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
