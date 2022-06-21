package utils;

public class ArrayGenerator {

    public static int[] random(int arrayMaxLength, int arrayMaxValue) {
        int length = (int)(Math.random() * (arrayMaxLength + 1));
        int[] help = new int[length];
        for (int i = 0; i < help.length; i++){
            help[i] = (int)(Math.random() * (arrayMaxValue + 1));
        }
        return help;
    }

    public static int[] random() {
        return random(20, 20);
    }
}
