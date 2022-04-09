package binarysearch.example;

import java.util.Arrays;

/**
 * 查询数组中某个值是否存在
 */
public class BSExist {
    public static boolean bsExist(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Arrays.sort(arr);
        int L = 0;
        int R = arr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + ((R - L) / 2);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                R = mid - 1;
            } else if (arr[mid] < target) {
                L = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 11, 13, 16};
        bsExist(arr, 11);
    }
}
