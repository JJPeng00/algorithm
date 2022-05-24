package dp;

public class ChooseCardsInLine {

    /**
     *暴力递归：
     */
    public static int chooseCard(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        //先拿不一定就赢，所以从先拿的和后拿的当中返回最大的，那就是获胜者的值
        return Math.max(
                f(arr, 0, arr.length - 1),
                s(arr, 0, arr.length - 1)
        );
    }

    private static int f(int[] arr, int L, int R) {
        //如果只有一个数，先拿的就拿走它
        if (L == R) {
            return arr[L];
        }
        //多个数的情况下，选取一个数，然后在一个更小的范围上变成了后拿者的身份
        return Math.max(
                arr[L] + s(arr, L + 1, R),
                arr[R] + s(arr, L, R -1)
        );
    }

    private static int s(int[] arr, int L, int R) {
        //如果只有一个数，那这个数就被先拿的人拿走了，后拿的人只能返回0
        if (L == R) {
            return 0;
        }
        //如果有多个数，那在先拿的人拿走一个后，后拿的人就变成了在一个更小的范围上的先拿者的身份，但拿到的数是先拿者条剩下的所以只能拿到一个小的数
        return Math.min(
                f(arr, L + 1, R),
                f(arr, L, R -1)
        );
    }

    /**
     * 动态规划
     */
    public static int dp(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int n = arr.length;
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = arr[i];
        }
        //s[i][i]
        for (int i = 1; i < n; i++) {
            int L = 0;
            int R = i;
            while (L < n && R < n) {
                //将调用递归的过程，替换成对表进行数据填充
                f[L][R] = Math.max(
                        arr[L] + s[L + 1][R],
                        arr[R] + s[L][R - 1]
                );

                s[L][R] = Math.min(
                        f[L + 1][R],
                        f[L][R - 1]
                );
                L++;
                R++;
            }
        }
        return Math.max(f[0][n - 1], s[0][n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 4,7,9,5,19,29,80,4 };
        System.out.println(chooseCard(arr));
        System.out.println(dp(arr));
    }
}
