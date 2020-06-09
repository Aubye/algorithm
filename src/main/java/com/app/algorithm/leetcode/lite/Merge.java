package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1, 6, 7, 0, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 0, nums2, 1);
        log.info("nums1:{}", nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int len = (m + n) - 1;
        while (mIndex >= 0 && nIndex >= 0) {
            nums1[len--] = nums1[mIndex] > nums2[nIndex] ? nums1[mIndex--] : nums2[nIndex--];
        }
        while (mIndex >= 0) {
            nums1[len--] = nums1[mIndex--];
        }
        while (nIndex >= 0) {
            nums1[len--] = nums2[nIndex--];
        }
    }

}
