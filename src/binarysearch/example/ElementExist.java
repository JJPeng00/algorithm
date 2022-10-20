package binarysearch.example;

import other.IntegerArrayGenerator;

import java.util.Arrays;
import java.util.OptionalInt;

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
        int[] arr = IntegerArrayGenerator.generate(100, 30);
        int element = (int) (Math.random() * 31);
        boolean elementExist = isElementExist(arr, element);
        //对数器遍历查找是否存在
        OptionalInt any = Arrays.stream(arr).findAny();
        System.out.println(elementExist == any.isPresent());
    }
}
