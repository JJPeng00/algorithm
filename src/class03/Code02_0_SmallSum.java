package class03;

import java.util.Arrays;

public class Code02_0_SmallSum {
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r){
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        int leftSum = process(arr, l, mid);
        int rightSum = process(arr, mid + 1, r);
        int allSum = merge1(arr, l, mid, r);
        return leftSum + rightSum + allSum;
//        return process(arr, l, mid) + process(arr, mid + 1, r) + merge1(arr, l, mid, r);
    }

    private static int merge1(int[] arr, int l, int mid, int r) {
       int[] help = new int[r - l + 1];
       int lp = l;
       int rp = mid + 1;
       int i = 0;
       int sum = 0;
       while (lp <= mid && rp <= r){
           sum += arr[lp] < arr[rp] ? arr[lp] * (r - rp + 1) : 0;
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
       return sum;
    }

    private static int[] generateRandomArray(int arrayMaxLength, int arrayMaxValue) {
        int length = (int)(Math.random() * (arrayMaxLength + 1));
        int[] help = new int[length];
        for (int i = 0; i < help.length; i++){
            help[i] = (int)(Math.random() * (arrayMaxValue + 1));
        }
        return help;
    }
    public static int badSmallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                sum += arr[i] < arr[j] ? arr[i] : 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean ans = true;
        for (int i = 0; i < 50000; i++){
            int[] arr1 = generateRandomArray(20, 20);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (smallSum(arr1) != badSmallSum(arr2)){
                System.out.println(Arrays.toString(arr1));
                ans = false;
                break;
            }
        }
        System.out.println(ans ? "nice" : "bad");
    }
}
