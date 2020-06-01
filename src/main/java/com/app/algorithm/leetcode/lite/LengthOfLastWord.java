package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LengthOfLastWord {

    public static void main(String[] args) {
        int length = lengthOfLastWord("   ");
        log.info("lengthOfLastWord:{}", length);
    }

    public static int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int right = 0;
        for (int i = array.length; i > 0; i--) {
            char c = array[i - 1];
            if (c != ' ') {
                right = i;
                break;
            }
        }
        int left = 0;
        for (int i = right; i > 0; i--) {
            char c = array[i - 1];
            if (c == ' ') {
                left = i;
                break;
            }
        }
        return right - left;
    }

}
