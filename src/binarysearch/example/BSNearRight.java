package binarysearch.example;

import java.util.Arrays;

/**
 * 找出有序数组中第一个>=某值的数的位置
 */
public class BSNearRight {
    private static int searchNearRight(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int index = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= target) {
                index = mid;
                right = right - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
