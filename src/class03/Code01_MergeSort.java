package class03;

import java.util.Arrays;

public class Code01_MergeSort {
    public static void mergeSort1(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int lp = l;
        int rp = mid + 1;
        int i = 0;
        while (lp <= mid && rp <= r){
            help[i++] = arr[lp] < arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid){
            help[i++] = arr[lp++];
        }
        while (rp <= r){
            help[i++] = arr[rp++];
        }
        for (i = 0; i < help.length; i++){
            arr[l + i] = help[i];
        }
    }
//    迭代实现，没有考虑溢出。
    public static void mergeSort2(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int n = arr.length - 1;
        int mergeSize = 1;
        while (mergeSize <= n){
            int l = 0;
            while (l <= n){
                int mid = l + mergeSize - 1;
                if (mid > n) {//剩下的数量不满足构成左边部分，那这些剩下的一定有序了。
                    break;
                }
                int r = Math.min(mid + mergeSize, n);
                merge(arr, l, mid, r);
                l = r + 1;
            }
            mergeSize <<= 1;
        }
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
            int[] arr1 = generateRandomArray(20, 20);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            mergeSort2(arr2);
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
