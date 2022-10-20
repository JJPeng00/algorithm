package binarysearch.example;

/**
 * 给定一个无序数组，任意两个相邻的数都不相等。返回其中的任意一个局部最小值的位置就行。
 */
public class DisorderedArrayLocalMinimumIndex {
    public static int searchLocalMinimumIndex(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        } else if (arr.length == 1) {
            return 0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid -1] < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }
}
