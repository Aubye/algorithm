package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int length1 = lengthOfLongestSubstring("abcabcbb");
        log.info("length:{}", length1);
        int length2 = lengthOfLongestSubstring("bbbbb");
        log.info("length:{}", length2);
        int length3 = lengthOfLongestSubstring("pwwkew");
        log.info("length:{}", length3);
        int length4 = lengthOfLongestSubstring("dvdf");
        log.info("length:{}", length4);
        int length5 = lengthOfLongestSubstring("ckilbkd");
        log.info("length:{}", length5);
    }

    /* 贪心算法需要考虑边界情况 非最优解  */
    public static int lengthOfLongestSubstring(String s) {
        char[] tmpChars = new char[128];

        int startIndex = 0;
        int maxLength = 0;

        char[] targetChars = s.toCharArray();
        for (int i = 0; i < targetChars.length; i++) {
            char targetChar = targetChars[i];
            int targetInt = (int) targetChar;
            if (tmpChars[targetInt] != 0) {
                for (int j = startIndex; j < i; j++) {
                    if (targetChar == targetChars[j]) {
                        startIndex = j + 1;
                    }
                }
                tmpChars[targetInt] = 0;
            }
            tmpChars[targetChar] = targetChar;
            int length = i - startIndex + 1;
            if (maxLength < length) {
                maxLength = length;
            }
        }
        return maxLength;
    }

}
