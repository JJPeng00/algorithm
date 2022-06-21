package sort.mergesort;

import utils.SortedValidator;

/**
 * @author JJPeng
 *
 * 归并排序递归实现：归并排序是将大问题化成小问题来解，两个单个元素的数组合并成一个双元素的数组，再将两个双元素的数组合并成一个四元素的数组，依此类推最终整个数组有序
 *      可以想象出类似二叉树，先将最下面一层叶子节点两两合并得到倒数第二层，再将倒数第二层两两合并
 *      1. 每一层从左往右两两合并，就需要知道有多少层（第一层循环）
 *      2. 也需要知道每一层分别是几个元素合并，也就能确定这一层需要循环多少次，而我们知道叶子节点层是两个单元素合并成双元素，之后的每一层的元素都是比上一层翻倍数量的合并
 */
public class MergeSortIteration {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1;
        int n = arr.length;
        //mergeSize在不断翻倍，但是不会超过n
        while (mergeSize <= n) {
            //每一层都从最左边开始合并
            int lp = 0;
            //左指针逐步向左移动，但不能越界
            while (lp < n) {
                //mid和右指针都不能越界
                int mid = Math.min(lp + mergeSize - 1, n - 1);
                int rp = Math.min(mid + mergeSize, n - 1);
                merge(arr, lp, mid, rp);
                lp = rp + 1;
            }
            mergeSize <<= 1;
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int lp = l;
        int rp = mid + 1;
        int i = 0;

        while(lp <= mid && rp <= r) {
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
        String validate = SortedValidator.validate(MergeSortIteration::mergeSort);
        System.out.println(validate);
    }
}
