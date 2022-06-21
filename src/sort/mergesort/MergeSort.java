package sort.mergesort;

import utils.SortedValidator;

/**
 * @author JJPeng
 *
 * 归并排序，将大问题化成小问题（利用递归），这里是用二分的思想将一个大的排序序列分成左右两个小的排序序列，将左右两边排好序后再合并
 * 时间复杂度：本算法的实现排序的功能是在merge时完成的，merge行为需要调用logN次，每一次merge的时间复杂度是O(n)，所以时间复杂度为O(n*logn)
 * 稳定性：可以做到稳定，merge时如果左边的数和右边的数相等，就取左边的值
 * 空间复杂度：O(n)
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int lp = l;
        int rp = mid + 1;
        int i = 0;

        while(lp <= mid && rp <= r) {
            //为了实现稳定性，左右两边两个数相等时，将左边的数放在前面
            help[i++] = arr[lp] <= arr[rp] ? arr[lp++] : arr[rp++];
        }
        while(rp <= r) {
            help[i++] = arr[rp++];
        }
        while (lp <= mid) {
            help[i++] = arr[lp++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        String validate = SortedValidator.validate(MergeSort::mergeSort);
        System.out.printf(validate);
    }
}
