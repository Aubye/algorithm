package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchInsert {

    public static void main(String[] args) {
        //int[] ints = {1, 3, 5, 6};
        //int i = searchInsert(ints, 5);
        //log.info("index:{}", i);
        int[] ints1 = {1};
        int i1 = searchInsert(ints1, 2);
        log.info("index1:{}", i1);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return target <= nums[left] ? left : left + 1;
    }

}
