package utils;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author JJPeng
 */
public class SortedValidator {

    public static String validate(Consumer<int[]> sortMethod) {
        int maxNum = 20;
        int maxSize = 50;
        int testTime = 999999;
        boolean accept = true;
        String badStr = "";
        for (int i = 0; i < testTime; i++) {
            int[] testArr = arrGenerate(maxNum, maxSize);
            int[] copyArr = Arrays.copyOf(testArr, testArr.length);
            Arrays.sort(testArr);
            sortMethod.accept(copyArr);
            accept = Arrays.equals(testArr, copyArr);
            if (!accept) {
                badStr = Arrays.toString(testArr) + "\r\n" + Arrays.toString(copyArr);
                break;
            }
        }
        return accept ? "accept" : badStr;
    }

    private static int[] arrGenerate(int maxNum, int maxSize) {
        //Math.random -> double类型的[0,1)
        //int强制转换是向0取整
        int size = (int)(Math.random() * (maxSize + 1));
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * (maxNum + 1));
        }
        return arr;
    }
}
