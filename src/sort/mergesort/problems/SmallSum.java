package sort.mergesort.problems;

/**
 * 小和问题：
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 例子： [1,3,4,2,5]
 *
 * > 1左边比1小的数，没有；
 * >
 * > 3左边比3小的数，1；
 * >
 * > 4左边比4小的数，1、3；
 * >
 * > 2左边比2小的数，1；
 * >
 * > 5左边比5小的数，1、3、4、2；
 * >
 * > 所以小和为1+1+3+1+1+3+4+2=16
 */

import utils.ArrayGenerator;

import java.util.Arrays;

/**
 * 分析：
 * 方法一：某个数的小和，是将其前面的数遍历一遍并把小于当前数的元素累加起来得到当前数的小和。数组的小和就等于各个元素的小和累加。
 * 方法二：在有序递增数组arr中，位置i < j，那么arr[i] < arr[j]，所以arr[i]的值将会在数组的小和中出现 (arr.size - j)次，
 *        而我们在利用归并排序时，左右两个部分合并时就能够判断，左边部分的每个元素在合并之后的
 */
public class SmallSum {

    //方法一
    public static  int traverseSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return sum;
    }


    //方法二
    public static int mergeSortSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (r - l) / 2 + l;
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int lp = l;
        int rp = mid + 1;
        int helpIndex = 0;
        int sum = 0;
        while (lp <= mid && rp <= r) {
            //当左右两边两个数相等时，必须先将rp移动到下一个比lp位置上的数大的位置，才知道当前rp位置上的数会在数组小和中出现几次
            sum += arr[lp] < arr[rp] ? arr[lp] * (r - rp + 1) : 0;
            help[helpIndex++] = arr[lp] < arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid) {
            help[helpIndex++] = arr[lp++];
        }
        while (rp <= r) {
            help[helpIndex++] = arr[rp++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean ans = true;
        for (int i = 0; i < 50000; i++){
            int[] arr1 = ArrayGenerator.random(20, 20);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (mergeSortSmallSum(arr1) != traverseSmallSum(arr2)){
                System.out.println(Arrays.toString(arr1));
                ans = false;
                break;
            }
        }
        System.out.println(ans ? "nice" : "bad");
    }
}
