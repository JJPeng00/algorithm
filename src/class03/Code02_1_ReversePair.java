package class03;

import java.util.Arrays;

public class Code02_1_ReversePair {
    public static void printReversePair(int[] arr, int l, int r){
        if (l == r){
            return;
        }
        int mid = l + ((r-l) >> 1);
        printReversePair(arr, l, mid);
        printReversePair(arr, mid + 1, r);
        merge2(arr, l, mid, r);
    }

    private static void merge2(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int pl = l;
        int pr = mid + 1;
        int i = 0;
        while (pl <= mid && pr <= r){
            if (arr[pl] > arr[pr]) {
                for (int j = pl; j <= mid; j++) {
                    System.out.println("[" + arr[j] + " , " + arr[pr] + "]");
                }
            }
            help[i++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
        }
        while (pl <= mid){
            help[i++] = arr[pl++];
        }
        while (pr <= r){
            help[i++] = arr[pr++];
        }
        i = 0;
        for (int j = l; j <= r - l; j++){
            arr[j] = help[i++];
        }
    }
    private static int[] generateRandomArray(int arrayMaxLength, int arrayMaxValue) {
        int length = (int)(Math.random() * (arrayMaxLength + 1));
        int[] help = new int[length];
        for (int i = 0; i < help.length; i++){
            help[i] = (int)(Math.random() * (arrayMaxValue + 1));
        }
        return help;
    }

}
