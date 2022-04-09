package eor.example;

/**
 * 一个数组中仅有一种数出现了奇数次，其他数都出现了偶数次，找到并打印这种出现了奇数次的数
 */
public class OneTypeOddTimesNum {
    public static void printOneTypeOddTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }
}
