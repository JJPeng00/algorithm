package sort;

import utils.IntegerArraySortedValidator;


/**
 * @author JJPeng
 *
 * 选择排序，从未排序序列中选取一个最小的数放到未排序序列的第一位，以实现从前往后依次递增的顺序
 * 时间复杂度：有n个数需要排序，每个数都需要遍历一遍所有未排序的元素，所以是n^2
 * 稳定性：当最小值存在多个时，取第一个最小值就能保证排的稳定性
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = arr[minValueIndex] < arr[j] ?  minValueIndex : j;
            }
            if (i != minValueIndex) swap(arr, i, minValueIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        String validate = IntegerArraySortedValidator.validate(SelectionSort::selectionSort);
        System.out.println(validate);
    }
}
