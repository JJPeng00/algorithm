package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Prim:
 *      从任意一个点开始，选择当下最小权重的边将所有的点连通起来。
 *      当下最小权重的边：每一次遍历一个新的节点都会得到新的边（这个节点与其他节点相连接的边）
 */
public class Prim {

    public Set<Edge> primMST(Graph graph) {
        //哪些点被遍历到了
        HashSet<Node> visitedNodes = new HashSet<>();
        //将可能被选择的边
        PriorityQueue<Edge> willVisitEdges = new PriorityQueue<>(Comparator.comparingInt(a -> a.wigth));

        HashSet<Edge> result = new HashSet<>();
        for (Node node : graph.nodeMap.values()) {//任意取一点，这里遍历的原因是要防森林
            if (!visitedNodes.contains(node)) {
                visitedNodes.add(node);
                willVisitEdges.addAll(node.edges);
                while (!willVisitEdges.isEmpty()) {
                    Edge edge = willVisitEdges.poll();
                    Node nextNode = edge.to;
                    if (!visitedNodes.contains(nextNode)) {
                        visitedNodes.add(nextNode);
                        result.add(edge);
                        willVisitEdges.addAll(nextNode.edges);
                    }
                }
            }
        }
        return result;
    }
}
