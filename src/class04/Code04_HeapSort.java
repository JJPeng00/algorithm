package class04;

import java.util.Arrays;

public class Code04_HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++){
            swap(arr, 0, --heapSize);
            heapfiy(arr, 0, heapSize);
        }
    }

    private static void heapfiy(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[largest] < arr[index]){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, ((index - 1) / 2));
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int maxArrayLength, int maxArrayValue){
        int length = (int)(Math.random() * (maxArrayLength + 1));
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++){
            randomArray[i] = (int)(Math.random() * (maxArrayValue + 1));
        }
        return randomArray;
    }

    public static void main(String[] args) {
        boolean ans = true;
        for (int i = 0; i < 500000; i++){
            int[] arr1 = generateRandomArray(30, 20);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            heapSort(arr2);
            if (!Arrays.equals(arr1, arr2)){
                ans = false;
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println(ans ? "nice!" : "bad!");
    }

}
