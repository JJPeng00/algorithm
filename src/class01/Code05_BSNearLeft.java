package class01;

import java.util.Arrays;

public class Code05_BSNearLeft {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        int index = process(arr, 10);
        System.out.println("index:" + index);
    }

    private static int process(int[] arr, int num) {
        if (arr == null || arr.length < 1){
            return -1;
        }
        int L = 0;
        int R = arr.length -1;
        int mid;
        int index = -1;
        while (L <= R){
            mid = L + ((R-L)>>1);
            if (arr[mid] >= num){//如果成立，mid位置上的数可能==num，又或者mid左边还可能还有比num大的数
                index = mid;//mid的左边可能没有了>=num的数了，所以先记录下这个位置，如果还有就替换呗
                R = mid - 1;//mid的左边可能还有>=num的数，试试看呗。
            } else {
                L = mid + 1;//mid的右边可能有比num大的数。
            }
        }
        return index;
    }
}
