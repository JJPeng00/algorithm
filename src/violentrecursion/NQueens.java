package violentrecursion;

/**
 * N皇后问题：
 * 指在N*N的棋盘上要摆N个皇后，要求任何两个皇后不同行，不同列，也不在同一斜线上给定一个整数n，返回n皇后的摆法有多少种。
 * n=1，返回1
 * n=2或3，二皇后和三皇后问题无论怎么摆都不行，返回0，
 * n=8，返回92
 *
 * 时间复杂度：
 * 如果是N皇后问题，那在第一行有N种选择，第二行有N种选择。所以是N^N。
 * 因为这是N皇后问题最好的试法了，所以N皇后问题经常用来测试计算机的性能。
 */
public class NQueens {

    public static int getNum(int i, int[] record, int n) {
        if (n == i) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (valid(record, i, j)) {
                record[i] = j;
                res += getNum(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean valid(int[] record, int i, int j) {

        for (int k = 0; k < i; k++) {
            //共列：纵坐标相等
            //共斜线：|横坐标 - 横坐标| == |纵坐标 - 纵坐标|
            if (record[k] == j || Math.abs(i - k) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 33;
        int[] record = new int[n];
        System.out.println(getNum(0, record, n));
    }
}
