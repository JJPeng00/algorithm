package class01;

public class Code07_EvenTimesOddTimes {
    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

        System.out.println(bit1Count(9));
    }

    private static int bit1Count(int num) {
        int count = 0;
        while (num != 0){
            count++;
            int rightOne = num & (~num + 1);
            num ^= rightOne;//把最右侧的1变为零
        }
        return count;
    }

    private static void printOddTimesNum2(int[] arr2) {
        int eor = 0;
        for (int i = 0; i < arr2.length; i++){
            eor ^= arr2[i];
        }
        int rightOne = eor & (~eor + 1);
        int ans = 0;
        for (int i = 0; i < arr2.length; i++){
            if ((arr2[i] & rightOne) != 0 ){
               ans ^= arr2[i];
            }
        }
        System.out.println(ans+" "+ (ans^eor));
    }

    private static void printOddTimesNum1(int[] arr1) {
        int eor = 0;
        for (int i = 0; i < arr1.length; i++){
            eor ^= arr1[i];
        }
        System.out.println(eor);
    }
}
