package dp;

/**
 * 从左往右的尝试模型，从左往右，每一个位置上都可以尝试要或者不要
 * 背包问题：
 * 给定两个长度都为N的数组weights和values，
 *
 * weights[i]和values[i]分别代表i号物品的重量和价值。
 *
 * 给定一个正数bag，表示一个载重量为bag的袋子。
 *
 * 返回你能装下最多的价值是多少（重量不能超过bag）？
 *
 * 例题：[416. 分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum/)
 */
public class BackpackDP {

    //返回在[index...]范围内可以获得的最大价值，还是进行拆分：大问题的结果 = 做出一个选择后 + 小问题的结果
    public static int getValue(int[] w, int[] v, int index, int rest) {
        int tack = 0;
        int notTack = 0;
        //如果还有剩余容量，且还有货物可拿,那才有的选
        if (rest > 0 && index < w.length) {
            //如果还够拿下这个,那才能选择拿，不然只能选择不拿
            if (rest >= w[index]) {
                tack = v[index];
                tack += getValue(w, v, index + 1, rest - w[index]);
            }
            notTack += getValue(w, v, index + 1, rest);
        }
        return Math.max(tack, notTack);
    }

    //直接通过暴力递归改成动态规划
    //在这里只有index和rest是可变参数，而我们是根据index 和 rest之间的关系来做递归的
    //在递归过程中有许多重复的操作
    //我们可以构造出由index 和 rest 之间的关系形成的二维表来作为缓存
    //且我们知道当index >= w.length时结果都为零，且我们知道当index == 0，且
    public static int getValueDP(int[] w, int[] v, int bag) {
        int n = w.length;

        int[][] dp = new int[n + 1][bag + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int tack = 0;
                int notTack = 0;
                if (rest > 0 && index < w.length) {
                    //如果还够拿下这个,那才能选择拿，不然只能选择不拿
                    if (rest >= w[index]) {
                        tack = v[index];
                        tack += dp[index + 1][rest - w[index]];
//                        tack += getValue(w, v, index + 1, rest - w[index]);
                    }
                    notTack += dp[index + 1][rest];
//                    notTack += getValue(w, v, index + 1, rest);
                }
                dp[index][rest] = Math.max(tack, notTack);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 , 10, 1, 2};
        int[] values = { 5, 6, 3, 19 , 100,1000, 1500};
        int bag = 11;
        int tack = getValue(weights, values, 0, bag);
        System.out.println(getValueDP(weights, values, bag));
        System.out.println(tack);
    }

}
