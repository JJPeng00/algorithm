package class01;

import java.util.Arrays;

public class Code02_BubbleSort {
    public static void bulleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length-1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,9,3,7,4,6,8,2};
        System.out.println(Arrays.toString(arr));
        bulleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
