package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegerReverse {

    public static void main(String[] args) {
        int reverse = reverse(Integer.MAX_VALUE);
        log.info("reverse:{}", reverse);
        boolean palindrome = isPalindrome(-121);
        int xii = romanToInt("IV");
        log.info("aaa");
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

    public static boolean isPalindrome(int x) {
        long y = 0;
        int target = x;
        while (target != 0) {
            y = y * 10 + target % 10;
            target = target / 10;
        }
        return (int) y == x;
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int prev = convertInt(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            int z = convertInt(chars[i]);
            if (z > prev) {
                result = result - prev;
            } else {
                result = result + prev;
            }
            prev = z;
        }
        return result + prev;
    }

    private static int convertInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
