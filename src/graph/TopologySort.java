package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 图的拓扑排序
 */
public class TopologySort {

    public static List<Node> sort(Graph graph) {
        //记录每个节点的剩余入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //入度为零的节点
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodeMap.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        //拓扑排序的结果
        List<Node> sortedResult = new LinkedList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            sortedResult.add(cur);
            //当前节点的后一个节点的入度减一
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return sortedResult;
    }

}
