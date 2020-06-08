package com.app.algorithm.leetcode.lite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = 0;
        int nIndex = 0;
        int index = 0;

        int[] ints = new int[m + n];
        while (mIndex < m && nIndex < n) {
            int mTemp = nums1[mIndex];
            int nTemp = nums2[nIndex];
            if (mTemp < nTemp) {
                ints[index++] = mTemp;
                mIndex++;
                continue;
            }
            ints[index++] = nTemp;
            nIndex++;
        }
        while (mIndex < m) {
            ints[index++] = nums1[mIndex++];
        }
        while (nIndex < n) {
            ints[index++] = nums2[nIndex++];
        }

        nums1 = ints;
        System.out.println(nums1.toString());
    }

}
