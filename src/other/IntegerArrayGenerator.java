package other;

import java.util.Arrays;

/**
 * @author JJPeng
 * @date 2022/10/20 19:00
 */
public class IntegerArrayGenerator {

    public static int[] generate(int maxSize, int maxValue) {
        int randomSize = (int) (Math.random() * (maxSize + 1));
        int [] arr = new int[randomSize];
        for (int i = 0; i < randomSize; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static int[] copy(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

}
