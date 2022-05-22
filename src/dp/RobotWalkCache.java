package dp;

/**
 * 机器人运动问题，因为暴力递归过程中有重复计算，所以这里使用缓存来省去重复计算的过程
 * 使用缓存优化，就是动态规划中的一种，叫做记忆化搜索
 *
 * 如果简简单单就只使用一个最傻的缓存的话是记忆化搜索，如果再把这个缓存优化的更精细些就是正常的动态规划了。
 */
public class RobotWalkCache {

    public static int waysCache(int n, int p, int cur, int rest) {
        // 参数无效直接返回0
        if (n < 2 || rest < 1 || cur < 1 || cur > n || p < 1 || p > n) {
            return 0;
        }

        int[][] dp = new int[n +1][rest +1];
        for(int row = 0; row <= n; row++) {
            for(int col = 0; col <= rest; col++) {
                dp[row][col] = -1;
            }
        }
        return walkCache(n, p, cur, rest, dp);
    }

    // HashMap<String, Integer>   (19,100) -> "19_100"，也可以做缓存
    // 使用缓存优化
    public static int walkCache(int n, int p, int cur, int rest, int[][] dpCache) {
        if(dpCache[cur][rest] != -1) {
            return dpCache[cur][rest];
        }
        if (rest == 0) {
            dpCache[cur][rest] = cur == p ? 1 : 0;
            return dpCache[cur][rest];
        }
        if (cur == 1) {
            dpCache[cur][rest] = walkCache(n, p, 2, rest - 1, dpCache);
            return dpCache[cur][rest];
        }
        if (cur == n) {
            dpCache[cur][rest] = walkCache(n, p, n - 1, rest - 1, dpCache);
            return dpCache[cur][rest];
        }
        dpCache[cur][rest] = walkCache(n, p, cur + 1, rest - 1, dpCache)
                + walkCache(n, p, cur - 1, rest - 1, dpCache);
        return dpCache[cur][rest];
    }


    //通过暴力递归的过程就可以直接推到出整个缓存表
    public static int waysCache2(int n, int p, int cur, int rest) {
        // 参数无效直接返回0
        if (n < 2 || rest < 1 || cur < 1 || cur > n || p < 1 || p > n) {
            return 0;
        }
        //默认值为零
        int[][] dp = new int[rest + 1][n + 1];
        //从暴力递归中，我们知道仅当rest == 0，且p = cur时有一个结果
        dp[0][p] = 1;
        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                } else if (j == n) {
                    dp[i][j] = dp[i - 1][n - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[rest][cur];
    }

    public static void main(String[] args) {
        System.out.println(waysCache(7, 5, 4, 9));
        System.out.println(waysCache2(7, 5, 4, 9));
    }

}
