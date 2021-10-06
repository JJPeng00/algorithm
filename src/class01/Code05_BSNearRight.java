package class01;

import java.util.Arrays;

public class Code05_BSNearRight {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        int index = process(arr, 8);
        System.out.println("index:" + index);
    }

    private static int process(int[] arr, int num) {
        if (arr == null || arr.length < 1){
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid;
        int index = 0;
        while (L <= R){
            mid = L + ((R - L) >> 1);
            if (arr[mid] <= num){
                index = mid;
                L = mid + 1;//右边可能还存在<=num的数
            } else {
                R = mid - 1;
            }
        }
        return index;
    }
}
