package dp;

/**
 * 范围上的尝试模型
 *
 * 机器人运动问题：
 *  假设有排成一行的N个位置，记为1~n，n 一定大于或等于 2
 *  初始时机器人在其中的M位置上(cur 一定是 1~n 中的一个)
 *      如果机器人来到第1位置，那么下一步只能往右来到第2个位置；
 *      如果机器人来到第n位置，那么下一步只能往左来到第 n-1 位置；
 *      如果机器人来到中间某位置(非中点），那么下一步可以往左走或者往右走；
 *  规定机器人必须走够 rest 步，最终能来到p位置(p也是1~n中的一个)的方法有多少种？
 */
public class RobotWalk {

    public static int ways(int n, int p, int cur, int rest) {
        if (n < 2 || rest < 1 || cur < 1 || cur > n || p < 1 || p > n) {
            return 0;
        }
        return walk(n, p, cur, rest);
    }
    public static int walk(int n, int p, int cur, int rest) {
        if (rest == 0) {
            return p == cur ? 1 : 0;
        }
        if (cur == 1) {
            return walk(n, p, 2, rest - 1);
        }
        if (cur == n) {
            return walk(n, p, n - 1, rest - 1);
        }
        //向左走的方法总数 + 向右走的方法总数
        return walk(n, p, cur - 1, rest - 1) + walk(n, p, cur + 1, rest - 1);
    }

    public static void main(String[] args) {
        System.out.println(ways(7, 5, 4, 9));
    }
}
