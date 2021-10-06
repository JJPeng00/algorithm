package class03;

import java.util.Arrays;

public class Code03_0_Partition1 {
    public static void partition1(int[] arr, int num){
        if (arr == null || arr.length < 2){
            return;
        }
        int p = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= num){
                swap(arr, i, ++p);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,9,6,3,2,4,8,7,9};
        partition1(arr, 7);
        System.out.println(Arrays.toString(arr));
    }
}
