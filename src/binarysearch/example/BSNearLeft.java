package binarysearch.example;

/**
 * 找出有序数组中最后一个<=某值的数的位置
 */
public class BSNearLeft {
    private static int searchNearLeft(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int index = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
