package class01;

import java.util.Arrays;

public class Code03_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,9,6,3,5,2,4,7,8};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j > 0; j--){
                if (arr[j-1] > arr[j]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
