package com.app.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Leetcode_7 {

    public static void main(String[] args) {
        int result = reverse(Integer.MAX_VALUE);
        log.info("result:{}", result);
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     */
    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

}
