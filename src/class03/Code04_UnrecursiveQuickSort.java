package class03;

import java.util.Arrays;
import java.util.Stack;

public class Code04_UnrecursiveQuickSort {
    public static class Op{
        int l;
        int r;
        public Op(int lp, int rp){
            this.l = lp;
            this.r = rp;
        }
    }
    public static void unrecursiveQuickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int n = arr.length - 1;
        swap(arr, n, (int)(Math.random()*(n + 1)));
        int[] equalArea = partition(arr,0, n);
        int lp = equalArea[0];
        int rp = equalArea[1];
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, lp - 1));
        stack.push(new Op(rp + 1, n));

        while (!stack.isEmpty()){
           Op op = stack.pop();
           if (op.r > op.l){
               swap(arr, op.r, op.l + (int)(Math.random()*(op.r - op.l + 1)));
               equalArea = partition(arr, op.l, op.r);
               lp = equalArea[0];
               rp = equalArea[1];
               stack.push(new Op(op.l,lp - 1));
               stack.push(new Op(rp + 1, op.r));
           }
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
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
            int[] arr1 = generateRandomArray(10, 10);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Arrays.sort(arr1);
            unrecursiveQuickSort(arr2);
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

