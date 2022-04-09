package eor.example;

/**
 * 一个数组中有两种数都出现了奇数次，其他数都出现了偶数次，找到并打印这两种出现了奇数次的数
 */
public class TwoTypesOddTimesNum {
    public static void printTwoTypesOddTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int a = 0;
        int rightestOne = (eor & ((~eor) + 1));
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightestOne) == 0) {
                a ^= arr[i];
            }
        }
        int b = a ^ eor;
        System.out.println("a: " + a + " b: " + b);
    }
}
