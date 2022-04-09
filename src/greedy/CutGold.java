package greedy;

import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。
 *
 * 比如长度为20的金条，不管怎么切成两半，都要花费20个铜板。 一群人想整分整块金条，怎么分最省铜板?
 *
 * 例如,给定数组{10,20,30}，代表一共分给三个人，金条总长度为60，金条要分成10，20，30三个部分。
 *
 * 如果先把长度60的金条分成10和50，花费60; 再把长度50的金条分成20和30，花费50;一共花费110铜板。
 *
 * 但如果先把长度60的金条分成30和30，花费60;再把长度30金条分成10和20， 花费30;一共花费90铜板。
 *
 *  输入一个数组，返回分割的最小代价。
 *
 * > 这就是所谓的哈夫曼编码树的思想。
 *
 * > 贪心策略：每一次划分出最大的块，再用另一块继续分出当前情况下剩余的需要分的最大的块。
 * >
 * > 反过来想：把当前最小的两个合并成一个大的，再继续上述过程。使用小根堆。
 * >
 * > 解：将所有的数放入小根堆，把堆顶的前两个数弹出，合并后丢回小根堆。重复上述过程，直到小根堆中只剩一个数。所有在此过程合并产生的数的和就是最终的代价。这相当于切分的逆过程。
 */
public class CutGold {

    public static int lessMoney1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return lessMoneyProcess(arr, 0);
    }

    private static int lessMoneyProcess(int[] arr, int cost) {
        if (arr.length == 1) {
            return cost;
        }
        int least = Integer.MAX_VALUE;
        //贪心策略是取当前最小的两个合并在一起，暴力方法就随机找两个数合并在一起，合并之后的数再随机找两个数合并来一起，递归将所有的情况都穷举一遍求最小值
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int[] mergedArray = mergeArrayInIndex(arr, i, j);
                least = Math.min(least, lessMoneyProcess(mergedArray, cost + arr[i] + arr[j]));
            }
        }
        return least;
    }

    private static int[] mergeArrayInIndex(int[] arr, int indexOne, int indexTwo) {
        int[] mergedArray = new int[arr.length - 1];
        int mergedArrayIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != indexOne && i != indexTwo) {
                mergedArray[mergedArrayIndex++] = arr[i];
            }
        }
        mergedArray[mergedArrayIndex] = arr[indexOne] + arr[indexTwo];
        return mergedArray;
    }

    public static int leastMoneyGreedy(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int least = 0;
        while (priorityQueue.size() > 1) {
            int cost = priorityQueue.poll() + priorityQueue.poll();
            least += cost;
            priorityQueue.add(cost);
        }
        return least;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 6;
        int maxValue = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            if (lessMoney1(arr) != leastMoneyGreedy(arr)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
