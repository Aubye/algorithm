package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RomanToInt {

    public static void main(String[] args) {
        int number = romanToInt("IV");
        log.info("romanToInt:{}", number);
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
