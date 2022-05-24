package dp;

/**
 * 给定数组arr，arr中所有的值都为正数且不重复
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张(无穷多）
 * 再给定一个整数 aim，代表要找的钱数
 * 求组成 aim 的方法数
 *
 * 例题：
 *      [面试题 08.11. 硬币](https://leetcode-cn.com/problems/coin-lcci/)
 *      [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)
 */
public class Coins {

    /**
     * 暴力递归
     */
    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    //可以使用arr[index ...]范围内的钱，组成值为rest的金额
    private static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int z = 0; z * arr[index] <= rest; z++) {
            ways += process(arr, index + 1, rest - z * arr[index]);
        }
        return ways;
    }

    /**
     * 记忆化搜索，使用傻缓存
     */
    public static int waysCache(int[] arr, int aim) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return cache(arr, 0, aim, dp);
    }

    private static int cache(int[] arr, int index, int rest, int[][] dp){
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            return dp[index][rest]= rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int z = 0; z * arr[index] <= rest; z++) {
            ways += cache(arr, index + 1, rest - z * arr[index], dp);
        }
        return dp[index][rest] = ways;
    }

    /**
     * 经典动态规划，时间复杂度和记忆化搜索的方式相同
     */
    private static int dp(int[] arr, int aim) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[n][0] = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest ++) {
                int ways = 0;
                //枚举行为，可以优化
                for(int z = 0;  z * arr[index] <= rest; z++) {
                    ways += dp[index + 1][rest -  (z * arr[index])];
//                    ways += process1(arr, index + 1, rest -  (z * arr[index])  );
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    /**
     * 枚举行为的优化分析：
     *  当z == 0 时， ways 依赖于 index的下一行 (rest - 0)列， 也就是下一行的同一列，因为z == 0
     *  当z == 1 时， ways 依赖于 index的下一行 (rest - z*arr[index])列， 也就是下一行的左移1 * arr[index]列，也就是左移z*当前货币面值列
     *  。。。。。。。
     *  求z == 0 到 。。。的累加和
     *
     *  如果现在要求index 的 rest列的值x，其实x=index行 (rest - z*arr[index])列的值加上index+1行rest列的值
     *
     *  因为z == 1 到 。。。。的累加和就是index行 (rest - z*arr[index])的值
     */
    private static int dpOptimize(int[] arr, int aim) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[n][0] = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest ++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10,50,100 };
        int sum = 1000;
        System.out.println(ways(arr, sum));
        System.out.println(waysCache(arr, sum));
        System.out.println(dp(arr, sum));
        System.out.println(dpOptimize(arr, sum));
    }
}
