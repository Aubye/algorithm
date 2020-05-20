package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestPalindrome {

    public static void main(String[] args) {
        String a = longestPalindrome("babad");
        log.info("a:{}", a);
        String b = longestPalindrome("cbbd");
        log.info("b:{}", b);
    }

    /*
     * 动态规划
     *      0 1 2 3 4
     *      a b a c e
     *  0 e 0 0 0 0 1
     *  1 c 0 0 0 1 0
     *  2 a 1 0 1 0 0
     *  3 b 0 2 0 2 0
     *  4 a 1 0 3 0 0
     */
    public static String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        if (length <= 1) {
            return s;
        }
        int a = 0;
        int maxLength = 1;
        int[][] ints = new int[length][length];
        for (int i = 0; i < charArray.length; i++) {
            char y = charArray[length - i - 1];
            for (int j = 0; j < ints.length; j++) {
                char x = charArray[j];
                ints[i][j] = x == y ? 1 : 0;
                if (i > 0 && j > 0 && ints[i][j] > 0 && ints[i - 1][j - 1] > 0) {
                    int len = ints[i - 1][j - 1] + 1;
                    ints[i][j] = len;
                    if (len > maxLength) {
                        a = i;
                        maxLength = len;
                    }
                }
            }
        }
        return s.substring(length - a - 1, length - a - 1 + maxLength);
    }

}
