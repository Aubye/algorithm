package org.learning.base.algorithm.search;

public class BinarySearch {

    public static int binarySearch(int[] items, int value) {
        int low = 0;
        int high = items.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (items[mid] == value) {
                return mid;
            } else if (items[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchFirst(int[] items, int value) {
        int low = 0;
        int high = items.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (items[mid] < value) {
                low = mid + 1;
            } else if (items[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || items[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearchLast(int[] items, int value) {
        int low = 0;
        int high = items.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (items[mid] < value) {
                low = mid + 1;
            } else if (items[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == items.length - 1 || items[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearchFirstEqualsOrMoreThan(int[] items, int value) {
        int low = 0;
        int high = items.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (items[mid] >= value) {
                if (mid == 0 || items[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchLastEqualsOrLessThan(int[] items, int value) {
        int low = 0;
        int high = items.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (items[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == items.length - 1 || items[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
