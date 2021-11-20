package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TwoSum {

    public static void main(String[] args) {
        int[] ints = {11, 2, 7, 15};
        int[] ints1 = {3, 2, 4};
        int[] result = twoSum2(ints1, 6);
        log.info("result:{}", result);
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

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                Integer index = map.get(target - num);
                result[0] = index;
                result[1] = i;
                break;
            }
            map.put(num, i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int index = 0;
        int tmp = index + 1;
        while (index < nums.length - 1) {
            if (nums[index] + nums[tmp] == target) {
                result[0] = index;
                result[1] = tmp;
                return result;
            }
            if (tmp < nums.length - 1) {
                tmp++;
                continue;
            }
            index++;
            tmp = index + 1;
        }
        return result;
    }

}
