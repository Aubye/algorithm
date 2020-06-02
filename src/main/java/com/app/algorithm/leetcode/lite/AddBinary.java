package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddBinary {

    public static void main(String[] args) {
        String result = addBinary("110010", "10111");
        //10101
        log.info("addBinary result:{}", result);
    }

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * 输入: a = "11", b = "1"
     * 输出: "100"
     */
    public static String addBinary(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();

        int length = Math.max(aCharArray.length + 1, bCharArray.length + 1);

        int aIndex = aCharArray.length - 1;
        int bIndex = bCharArray.length - 1;

        int index = length - 1;
        char[] tempArray = new char[length];
        boolean flag = false;
        while (aIndex >= 0 && bIndex >= 0) {
            char aChar = aCharArray[aIndex--];
            char bChar = bCharArray[bIndex--];
            if (aChar == bChar && aChar == '1') {
                tempArray[index] = '0';
                if (flag) {
                    tempArray[index] = '1';
                }
                flag = true;
            } else if (aChar == bChar && aChar == '0') {
                tempArray[index] = '0';
                if (flag) {
                    tempArray[index] = '1';
                }
                flag = false;
            } else {
                tempArray[index] = '1';
                if (flag) {
                    tempArray[index] = '0';
                    flag = true;
                    index--;
                    continue;
                }
                flag = false;
            }
            index--;
        }
        while (aIndex >= 0) {
            char aChar = aCharArray[aIndex--];
            if (flag && aChar == '1') {
                tempArray[index--] = '0';
                flag = true;
            } else if (flag && aChar == '0') {
                tempArray[index--] = '1';
                flag = false;
            } else {
                tempArray[index--] = aChar;
            }
        }
        while (bIndex >= 0) {
            char bChar = bCharArray[bIndex--];
            if (flag && bChar == '1') {
                tempArray[index--] = '0';
                flag = true;
            } else if (flag && bChar == '0') {
                tempArray[index--] = '1';
                flag = false;
            } else {
                tempArray[index--] = bChar;
            }
        }
        if (flag) {
            tempArray[0] = '1';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < tempArray.length; i++) {
            if (tempArray[i] == '\u0000') {
                continue;
            }
            stringBuilder.append(tempArray[i]);
        }
        return stringBuilder.toString();
    }

}
