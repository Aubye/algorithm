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


    public static int binarySearch1(int[] items, int value) {
        int left = 0;
        int right = items.length / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid] == value) {
                return mid;
            }
            if (items[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchFirst1(int[] items, int value) {
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (items[mid] == value) {
                if (mid == 0 || items[mid - 1] != value) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchLast1(int[] items, int value) {
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid] == value) {
                if (mid == items.length - 1 || items[mid + 1] != value) {
                    return mid;
                }
                left = mid + 1;
            } else if (items[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchFirstEqualsOrMoreThan1(int[] items, int value) {
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid] >= value) {
                if (mid == 0 || items[mid - 1] < value) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchLastEqualsOrLessThan1(int[] items, int value) {
        int left = 0;
        int right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid] <= value) {
                if (mid == items.length - 1 || items[mid + 1] > value) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{0, 1, 1, 2, 2, 3, 4, 5};
        int binarySearch = binarySearch(intArray, 1);
        int binarySearch1 = binarySearch1(intArray, 1);
        int binarySearchFirst = binarySearchFirst(intArray, 1);
        int binarySearchFirst1 = binarySearchFirst1(intArray, 1);
        int binarySearchLast = binarySearchLast(intArray, 1);
        int binarySearchLast1 = binarySearchLast1(intArray, 1);
        int binarySearchFirstEqualsOrMoreThan = binarySearchFirstEqualsOrMoreThan(intArray, 1);
        int binarySearchFirstEqualsOrMoreTha1 = binarySearchFirstEqualsOrMoreThan1(intArray, 1);
        int binarySearchLastEqualsOrLessThan = binarySearchLastEqualsOrLessThan1(intArray, 1);
        int binarySearchLastEqualsOrLessThan1 = binarySearchLastEqualsOrLessThan1(intArray, 1);
        System.out.println("finish");
    }

}
