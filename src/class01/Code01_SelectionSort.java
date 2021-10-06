package class01;

import java.util.Arrays;

public class Code01_SelectionSort {
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i; j < arr.length; j++){
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,9,3,7,4,6,8,2};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
