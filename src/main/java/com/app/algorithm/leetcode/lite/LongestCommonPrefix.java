package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strArray = new String[]{"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strArray);
        log.info("prefix:{}", prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        int equalNumber = 0;
        int arrayLength = strs.length;
        if (arrayLength == 0) {
            return "";
        }
        int charIndex = 0;
        char prevChar = 0;
        while (true) {
            if (index >= arrayLength) {
                index = 0;
            }
            String str = strs[index++];
            if (charIndex + 1 > str.length()) {
                break;
            }
            char strChar = str.charAt(charIndex);
            if (equalNumber == 0) {
                equalNumber++;
                prevChar = strChar;
                continue;
            }
            if (strChar != prevChar) {
                break;
            }
            equalNumber++;
            if (equalNumber >= arrayLength) {
                charIndex++;
                equalNumber = 0;
                index = 0;
            }
        }
        return strs[0].substring(0, charIndex);
    }

}
