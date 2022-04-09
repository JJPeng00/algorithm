package eor.example;

/**
 * 统计一个数中有多少位是1
 */
public class BitOneCount {
    public static int bitOneCount(int num) {
        int count = 0;
        while (num != 0) {
            int rightestOne = num & (~num + 1);//找到一个最右侧的1
            count++;
            num ^= rightestOne;//把最右侧的1的位置变为零，其他位置不变
        }
        return count;
    }
}
