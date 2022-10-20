package binarysearch.example;

import other.IntegerArrayGenerator;

import java.util.Arrays;

/**
 * 查询数组中某个值是否存在
 */
public class ElementExist {
    public static boolean isElementExist(int[] arr, int target) {
       if (arr == null || arr.length < 1) {
           return false;
       }
       //保证数组有序
       Arrays.sort(arr);

       int left = 0;
       int right = arr.length - 1;
       int mid;

       while (left <= right) {
           mid = left + (right - left) / 2;
           if (target == arr[mid]) {
               return true;
           } else if (target < arr[mid]) {
               right = mid - 1;
           } else {
               left = mid + 1;
           }
       }
       return false;
    }

    public static void main(String[] args) {
        for (int i = 1000000; i > 0; i--) {
            int[] arr = IntegerArrayGenerator.generate(100, 90);
            int element = (int) (Math.random() * 31);
            boolean elementExist = isElementExist(arr, element);
            boolean b = Arrays.stream(arr).anyMatch(p -> p == element);
            if ( !elementExist == b) System.out.println("bad");
        }
        System.out.println("finish");
    }
}
