package class03;

import java.util.Arrays;

public class Code03_QuickSort {
    //经典快排，每次只确定分割点的位置上的一个数
    public static void quickSort1(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int l, int r) {
        if (l >= r){//当flag左边和l之间只有一个数时或者当flag右边和r之间只有一个数时。
            return;
        }
        int flag = partition1(arr, l, r);
        process1(arr, l, flag - 1);//当flag处于l位置，即数组的第一个位置上，那么就需要l > r作为递归基
        process1(arr, flag + 1, r);//当flag处于r位置，即数组的最后一个位置上，那么就需要l > r作为递归基
    }
    //经典快排的分区方案
    private static int partition1(int[] arr, int l, int r) {
        int p = l - 1;
        for (int i = l; i < r; i++){
            if (arr[i] <= arr[r]){
                swap(arr, i, ++p);
            }
        }
        swap(arr, r, ++p);
        return p;
    }

    //荷兰国旗问题改进的快排，每次可以确定等于划分数的好几个数，常数时间更低
    public static void quickSort2(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process2(arr, 0, arr.length - 1);
    }
    private static void process2(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int[] flags = partition2(arr, l, r);
        process2(arr, l, flags[0] - 1);
        process2(arr, flags[1] + 1, r);
    }
    //荷兰国旗版改进型的分区方案
    private static int[] partition2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        for (int i = l; i < more; i++){
            if (arr[i] < arr[r]){
                swap(arr, i, ++less);
            } else if (arr[i] > arr[r]){
                swap(arr, i--, --more);
            }
        }
        swap(arr, r, more);
        return new int[] {less + 1, more};
    }

    //随机快排
    public static void quickSort3(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process3(arr, 0, arr.length - 1);
    }
    private static void process3(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] flags = partition2(arr, l, r);
        process3(arr, l, flags[0] - 1);
        process3(arr, flags[1] + 1, r);
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
        for (int i = 0; i < 5000000; i++){
            int[] arr1 = generateRandomArray(30, 20);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
//            quickSort1(arr2);
//            quickSort2(arr2);
            quickSort3(arr2);
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
