package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlusOne {

    public static void main(String[] args) {
        int[] ints = {9, 9};
        int[] result = plusOne(ints);
        log.info("result:{}", result);
    }

    // [1,2,3] -> [1,2,4]
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean flag = false;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            }
            digits[i] = 0;
            if (i == 0) {
                flag = true;
            }
        }

        if (!flag) {
            return digits;
        }

        int[] ints = new int[length + 1];
        ints[0] = 1;
        int index = 0;
        while (index < digits.length) {
            ints[index + 1] = digits[index];
            index++;
        }
        return ints;
    }

}
