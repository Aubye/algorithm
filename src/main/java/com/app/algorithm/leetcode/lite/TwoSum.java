package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoSum {

    public static void main(String[] args) {
        int[] ints = {11, 2, 7, 15};
        int[] ints1 = twoSum(ints, 9);
        log.info("result:{}", ints1);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;

        int index = 0;
        int temp = index + 1;

        while (index < len - 1) {
            int count = nums[index] + nums[temp];
            if (count == target) {
                result[0] = index;
                result[1] = temp;
                break;
            }
            if (temp < len - 1) {
                temp = temp + 1;
                continue;
            }
            index = index + 1;
            temp = index + 1;
        }
        return result;
    }

}
