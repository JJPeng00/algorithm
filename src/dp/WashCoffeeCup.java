package dp;

/**
 * 业务限制的尝试模型
 *
 * 给定一个数组，代表每个人喝完咖啡准备刷杯子的时间点，[1,5,2]即代表分别准备在1，5，2时间节点洗杯子
 * 只有一台咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯
 * 每个咖啡杯也可以自己挥发干净，时间耗费b，咖啡杯可以并行挥发
 * 返回让所有咖啡杯变干净的最早完成时间
 * 三个参数：int[] arr、int a、int b
 */
public class WashCoffeeCup {

    /**
     * 暴力递归：
     *      通过将一个大问题化减成小问题，先搞定完一个杯子，剩下的杯子递归解决，而搞定每一个杯子都有两种选择。
     *
     */
    public static int process(int[] arr, int a, int b, int index, int doneTimeLine) {
        if (index == arr.length - 1) {
            return Math.min(
                    Math.max(doneTimeLine, arr[index]) + a,
                    arr[index] + b
            );
        }

        //选择用咖啡机洗
        int curWashedTime = Math.max(doneTimeLine, arr[index]) + a;
        int restDoneTime = process(arr, a, b, index + 1, curWashedTime);
        int aPlanDoneTime = Math.max(curWashedTime, restDoneTime);

        //选择自然挥发
        int curDryTime = arr[index] + b;
        int restDoneTimeB = process(arr, a, b, index + 1, doneTimeLine);
        int bPlanDoneTime = Math.max(curDryTime, restDoneTimeB);

        return Math.min(aPlanDoneTime, bPlanDoneTime);
    }


    /**
     * 动态规划：
     *      有两个可变参数，可构成一个二维缓存表。需要确定表的大小，index是确定的，
     */
    public static int dp(int[] arr, int a, int b) {
        int n = arr.length;
        //这是一个可能的结果，可能是最优的结果，因为要求的是最少的时间，所有我们完全可以用一个可能的结果来作为最终答案的上限
        //因为最终答案只会小于等于这个值
        int possibleDoneTime = arr[n - 1] + b;

        int[][] dp = new int[n][possibleDoneTime + 1];

        //n - 1
        for (int doneTime = 0; doneTime <= possibleDoneTime; doneTime++) {
            dp[n - 1][doneTime] = Math.min(Math.max(doneTime, arr[n - 1]) + a, arr[n - 1] + b);
        }

        for (int index = n - 2; index >= 0; index--) {
            for (int doneTime = 0; doneTime <= possibleDoneTime; doneTime++) {
                //选择用咖啡机洗
                int curWashedTime = Math.max(doneTime, arr[index]) + a;
                int restDoneTime = Integer.MAX_VALUE;
                if (curWashedTime <= possibleDoneTime) {
                    //如果洗完当前杯子的时间已经超出了我们预设的可能值，那当前方式一定不是最佳的
                    restDoneTime = dp[index + 1][curWashedTime];
                }
                int aPlanDoneTime = Math.max(curWashedTime, restDoneTime);

                //选择自然挥发
                int curDryTime = arr[index] + b;
                int restDoneTimeB = dp[index + 1][doneTime];
                int bPlanDoneTime = Math.max(curDryTime, restDoneTimeB);

                dp[index][doneTime] = Math.min(aPlanDoneTime, bPlanDoneTime);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] test = { 1, 1, 5, 5, 7, 10, 12, 12, 12, 12, 12, 12, 15 };//结果：20
        int a1 = 5;
        int b1 = 6;
        System.out.println(process(test, a1, b1, 0, 0));
        System.out.println(dp(test, a1, b1));
    }
}
