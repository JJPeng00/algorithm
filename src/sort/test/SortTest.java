package sort.test;

import sort.BubbleSort;
import sort.InsertionSort;
import sort.SelectionSort;

import java.util.Arrays;

public class SortTest {
    private static int[] arrGenerate(int maxNum, int maxSize) {
        int size = (int)(Math.random() * (maxSize + 1));
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * (maxNum + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int maxNum = 20;
        int maxSize = 10;
        int testTime = 999999;
        Boolean accept = true;
        for (int i = 0; i < testTime; i++) {
            int[] testArr = arrGenerate(maxNum, maxSize);
            int[] copyArr = Arrays.copyOf(testArr, testArr.length);
            Arrays.sort(testArr);
//            BubbleSort.bubbleSort(copyArr);
//            InsertionSort.insertionSort(copyArr);
//            SelectionSort.selectionSort(copyArr);
            accept = Arrays.equals(testArr, copyArr);
            if (!accept) {
                System.out.println("bad!");
                System.out.println(Arrays.toString(testArr));
                System.out.println(Arrays.toString(copyArr));
                break;
            }
        }
        System.out.println(accept ? "accept" : "bad");
    }
}
