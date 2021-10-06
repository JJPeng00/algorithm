package class01;

import java.util.Arrays;

public class Code04_BSExist {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        System.out.println(exist(arr, 10));
        System.out.println(exist(arr, 2));
    }

    private static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0){
            return false;
        }
        int L = 0;
        int R = arr.length-1;
        int mid;
        while (L <= R){
            mid = L + ((R - L) >> 1);
            if (arr[mid] == num){
                return true;
            } else if (arr[mid] > num){//mid的左边可能存在有==num的数
                R = mid - 1;//等于num的数可能在mid的左边存在，而一定不在mid的右边
            } else{
                L = mid + 1;//mid的右边可能存在有==num的数
            }
        }
        return false;
    }
}
