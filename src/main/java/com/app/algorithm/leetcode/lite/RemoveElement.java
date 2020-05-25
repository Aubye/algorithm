package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveElement {

    public static void main(String[] args) {
        int[] ints = {2, 2, 2, 2};
        int length = removeElement(ints, 2);
        log.info("removeElement length:{}", length);
    }

    // nums = [3,2,2,3], val = 3,
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int num : nums) {
            if (num == val) {
                continue;
            }
            nums[index] = num;
            index++;
        }
        return index;
    }

}
