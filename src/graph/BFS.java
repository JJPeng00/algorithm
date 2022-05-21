package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树都是先遍历左孩子再遍历右孩子（或相反），遍历的顺序和孩子数量是固定的所以无需使用额外的数据结构来记录遍历的顺序，仅通过函数递归调用就可以完成宽度和深度优先遍历；
 * 与二叉树相比图节点的孩子数是不确定的，所以我们用一个结构来记录遍历过的节点，使用另一个数据结构来记录遍历的顺序。
 * note：由于函数的递归调用可能会出现栈溢出，所以可以将这种递归调用改为迭代。（应用图的宽度优先和深度优先遍历思想）
 */
public class BFS {

    //从指定节点出发，进行宽度优先遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        //使用队列来保存之后节点的遍历顺序，直到队列为空，则遍历完成
        Queue<Node> nextVisitQueue = new LinkedList<>();
        HashSet<Node> visitedSet = new HashSet<>();//图可能会有环，所以需要防止一个点多次进入队列
        nextVisitQueue.add(node);
        visitedSet.add(node);
        while (!nextVisitQueue.isEmpty()) {
            Node cur = nextVisitQueue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!visitedSet.contains(next)) {
                    nextVisitQueue.add(node);
                    visitedSet.add(node);
                }
            }
        }
    }
}
