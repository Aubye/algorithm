package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
public class ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {0, 0, 0, 0, 0, 1};
        List<List<Integer>> result = threeSumZero(nums);
        List<List<Integer>> result1 = threeSumZero1(nums);
        log.info("result:{}", result);
        log.info("result1:{}", result1);
    }

    public static List<List<Integer>> threeSumZero(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i > 0 && nums[i - 1] == num) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumZero1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                    continue;
                }
                if (sum < 0) {
                    left++;
                    continue;
                }
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            }
        }
        return result;
    }

}
