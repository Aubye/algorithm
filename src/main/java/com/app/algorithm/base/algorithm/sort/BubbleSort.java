package com.app.algorithm.base.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * O(n^2)
 * Simple
 * 每次都将最大的数放在右边,外层循环控制对从哪个下标开始
 */
public class BubbleSort {

    private static void sort(int[] items) {
        if (items.length <= 1) {
            return;
        }
        for (int i = 0; i < items.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < items.length - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    private static void sort1(int[] items) {
        if (items.length <= 1) {
            return;
        }
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length - i - 1; j++) {
                if (items[j] > items[j + 1]) {
                    int temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] items = {0, 5, 4, 6, 1, 3, 7, 8, 9, 2};
        int[] items1 = {0, 5, 4, 6, 1, 3, 7, 8, 9, 2};
        sort(items);
        sort1(items1);
        System.out.println(Arrays.toString(items));
        System.out.println(Arrays.toString(items1));
        System.out.println("finish");
    }

}
