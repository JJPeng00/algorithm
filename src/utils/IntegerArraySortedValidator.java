package utils;

import other.IntegerArrayGenerator;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author JJPeng
 */
public class IntegerArraySortedValidator {

    public static String validate(Consumer<int[]> sortMethod) {
        int maxNum = 20;
        int maxSize = 50;
        int testTime = 999999;
        boolean accept = true;
        String badStr = "";
        for (int i = 0; i < testTime; i++) {
            int[] randomArr = IntegerArrayGenerator.generate(maxSize, maxNum);
            int[] copyArr = Arrays.copyOf(randomArr, randomArr.length);
            Arrays.sort(randomArr);
            sortMethod.accept(copyArr);
            accept = Arrays.equals(randomArr, copyArr);
            if (!accept) {
                badStr = Arrays.toString(randomArr) + "\r\n" + Arrays.toString(copyArr);
                break;
            }
        }
        return accept ? "accept" : badStr;
    }
}
