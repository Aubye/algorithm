package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxSubArray {

    public static void main(String[] args) {
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubSum = maxSubArray(ints);
        log.info("maxSubSum:{}", maxSubSum);
    }

    /**
     * 正向增益
     * [-2,1,-3,4,-1,2,1,-5,4]
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    /**
     * 动态规划
     * [-2,1,-3,4,-1,2,1,-5,4]
     */
    public static int maxSubArray1(int[] nums) {
        int result = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        for (int value : dp) {
            result = Math.max(result, value);
        }
        return result;
    }

}
