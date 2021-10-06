package class03;

import java.util.Arrays;

public class Code03_1_Partition2 {
    public static void partition2(int[] arr, int num){
        if (arr == null || arr.length < 2){
            return;
        }
        int less = -1;
        int more = arr.length;
        for (int i = 0; i < more; i++){//注意终止条件
            if (arr[i] < num){
                swap(arr, i, ++less);
            } else if (arr[i] > num){
                swap(arr, i--, --more);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,9,3,6,4,8,2,8,4};
        partition2(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
