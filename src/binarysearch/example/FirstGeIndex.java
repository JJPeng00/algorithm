package binarysearch.example;

import java.util.Arrays;

/**
 * 找出有序数组中第一个大于等于某值的数的位置
 */
public class FirstGeIndex {

    public static int searchIndexByValue(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int mid;
        int index = -1;

        while(left <= right) {
            mid = left + (right - left)/2;

            if (arr[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
