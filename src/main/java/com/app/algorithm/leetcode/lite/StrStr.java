package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrStr {

    public static void main(String[] args) {
        int i = strStr("hello", "ll");
        log.info("strStr:{}", i);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] contextChars = haystack.toCharArray();
        int contextLength = contextChars.length;
        char[] targetChars = needle.toCharArray();
        int targetLength = targetChars.length;
        for (int i = 0; i < contextLength - targetLength + 1; i++) {
            int j;
            for (j = 0; j < targetLength; j++) {
                if (contextChars[i + j] != targetChars[j]) {
                    break;
                }
            }
            if (j == targetLength) {
                return i;
            }
        }
        return -1;
    }

}
