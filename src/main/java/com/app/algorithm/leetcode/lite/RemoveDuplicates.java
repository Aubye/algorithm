package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(ints);
        log.info("removeDuplicates length:{}", length);
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (i == 0) {
                index++;
                prev = temp;
                continue;
            }
            if (prev != temp) {
                nums[index++] = temp;
            }
            prev = temp;
        }
        return index;
    }

}
