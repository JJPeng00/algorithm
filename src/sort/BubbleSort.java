package sort;

import utils.SortedValidator;

/**
 * @author JJPeng
 *
 * 冒泡排序，将大的数逐步后移，从而实现从后往前依此有序
 * 时间复杂度：需要排n个数，每个数都需要遍历一遍未排序的的所有元素，所以是n^2
 * 稳定性：相等的数不交换就不会破坏稳定性
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String validate = SortedValidator.validate(BubbleSort::bubbleSort);
        System.out.println(validate);
    }
}
