package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * 解决的问题：给定一个点，求该点到所有节点（包括该节点本身）的最短距离；限制：边的权重不为负。
 * Note:Dijkstra就是一种贪心算法。通过每次都找到离当前节点a最近的节点b，再通过b找到最近的节点c
 * （当然我们还可以通b节点跳转到其他节点f，但距离可能不是最小的，但我们依然需要记录a通过b到f的距离，如果之后我们发现a->b->c-f的距离比a->b->f的距离更小，那我们就更新a->f的距离）。
 * 依次类推
 */
public class Dijkstra {

    public static HashMap<Node, Integer> dijkstra(Node from) {
        //给定点到其他点的距离表
        HashMap<Node, Integer> distances = new HashMap<>();
        distances.put(from, 0);
        //已经过的节点，因为每一个经过的节点都是从最小的路径得到的，所以这些节点的距离是确定的
        HashSet<Node> visitedNodes = new HashSet<>();

        Node minDistanceNode = from;
        while (minDistanceNode != null) {
            visitedNodes.add(minDistanceNode);
            for (Edge edge : minDistanceNode.edges) {
                Node toNode = edge.to;
                Integer minDistance = distances.get(minDistanceNode);
                if (!distances.containsKey(toNode)) {
                    distances.put(toNode, minDistance + edge.weight);
                } else {
                    distances.put(toNode, Math.min(distances.get(toNode), minDistance + edge.weight));
                }
            }
            minDistanceNode = findMinDistanceFromNotVisited(visitedNodes, distances);
        }
        return distances;
    }

    private static Node findMinDistanceFromNotVisited(HashSet<Node> visitedNodes, HashMap<Node, Integer> distances) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> distanceEntry : distances.entrySet()) {
            if (!visitedNodes.contains(distanceEntry.getKey()) && distanceEntry.getValue() < minDistance) {
                minDistance = distanceEntry.getValue();
                minNode = distanceEntry.getKey();
            }
        }
        return minNode;
    }
}
