package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入: 正数数组costs（花费）、正数数组profits（利润）、正数K、正数M
 *  costs[i]表示i号项目的花费
 *
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 *
 * K表示你只能串行的最多做k个项目
 *
 * M表示你初始（启动）的资金
 *
 * 说明: 每做完一个项目，马上获得的收益，可以支持你去做下一个项目。不能并行的做项目。
 *
 * 输出：你最后获得的最大钱数。
 *
 * > 贪心策略:从当前能投资的项目中找一个利润最高的项目做，获得收益后再从能投资的项目中找一个利润最大的项目做。直到做了k个项目。
 * >
 * > 先使用小根堆按花费排序（锁住的项目），再使用一个大根堆按利润排序（解锁的项目）。
 * >
 * > 暴力解：
 */
public class IPO {

    public static class Project {
        int cost;
        int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static int findMaxProfit(int k, int w, int[] costs, int[] profits) {
        PriorityQueue<Project> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Project> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < costs.length; i++) {
            minCostQ.add(new Project(costs[i], profits[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().profit;
        }
        return w;
    }


    private static class MinCostComparator implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return (o1.cost - o2.cost);
        }
    }

    private static class MaxProfitComparator implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return (o1.profit - o2.profit);
        }
    }
}
