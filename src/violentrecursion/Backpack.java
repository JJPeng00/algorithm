package violentrecursion;

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
public class Backpack {

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

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 , 10, 1};
        int[] values = { 5, 6, 3, 19 , 100,1000};
        int bag = 11;
        int tack = getValue(weights, values, 0, bag);
        System.out.println(tack);
    }

}
