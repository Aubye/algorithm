package com.app.algorithm.leetcode.number.n1;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TwoSum {

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 9;
        int[] result = twoSum(nums, target);
        log.info("result:{}", result);
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(target - nums[i])) {
                return new int[]{numIndexMap.get(target - nums[i]), i};
            }
            numIndexMap.put(nums[i], i);
        }
        return null;
    }

}
