package binarysearch.example;

import java.util.Arrays;

/**
 * 找出有序数组中最后一个小于等于某值的数的位置，即value的左边的第一个
 */
public class LastLeIndex {

    public static int searchIndexByValue(int[] arr, int value) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int mid;
        int index = -1;

        while (left <= right) {
            mid = left + (right - left)/2;

            //可以合并优化，目前保留最原始的方式
            if (arr[mid] == value) {
                index = mid;
                left = mid + 1;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value){
                index = mid;
                left = mid + 1;
            }
        }
        return index;
    }
}
