package other;

import java.util.Arrays;

/**
 * @author JJPeng
 * @date 2022/10/20 19:06
 */
public class StringArrayGenerator {

    public static String[] generate(int maxSize, int maxStrLen) {
        int randomSize = (int) (Math.random() * (maxSize + 1));
        String[] arr = new String[randomSize];
        for (int i = 0; i < randomSize; i++) {
            arr[i] = generateRandomString(maxStrLen);
        }
        return arr;
    }

    private static String generateRandomString(int maxStrLen) {
        int randomLen = (int) (Math.random() * (maxStrLen + 1));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < randomLen; i++) {
            char c = generateChar();
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static char generateChar() {
        int value = (int) (Math.random() * 26);
        //ascii码中A是65，a是97
        return (char) (Math.random() <= 0.5 ? 65 + value : 97 + value);
    }

    public static String[] copy(String[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

}
