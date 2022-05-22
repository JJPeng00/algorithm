package dp;

/**
 * [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)
 *
 * 斐波拉契数列是这样一个数列：0、1、1、2、3、5、8、13、21、34、……在数学上，
 * 斐波那契数列以如下递推的方法定义：
 * F(0) = 0，
 * F(1) = 1,
 * F(n) = F(n - 1) + F(n - 2)（n ≥ 2，n ∈ N*）。
 *
 * 注意到在递归中，如求f(7) = f(6) + f(5);  f(6) = f(5) + f(4)
 *
 * 可以看到f(5)就被重复计算了，所以可以思考优化，将计算过的值缓存起来。
 *
 * 暴力递归都是由于有重复计算才暴力的。
 */
public class FiboratchiSequence {

    public int f(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }
}
