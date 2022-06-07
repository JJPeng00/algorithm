package sort;

import utils.SortedValidator;

/**
 * @author JJPeng
 *
 * 插入排序，选取一张牌，插入到已排序序列中，这张牌是最靠近已排序序列的牌
 * 时间复杂度：有n个数需要排序，每个数都最多需要遍历一遍所有的已排序的元素，所以是n^2，但在遇到第一个小于排序值的数时就会停止，所以常数时间较低，最快的时间复杂度是n
 * 稳定性：相等时不做交换，所以具有稳定性
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
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
        String validate = SortedValidator.validate(InsertionSort::insertionSort);
        System.out.println(validate);
    }
}
