package graph;

import java.util.*;

/**
 * 图的最小生成树算法
 * 最小生成树：原始的图是由很多有权重的边连在一起的，最小生成树是将所有的点连在一起但仅保留权重最小的边
 * Kruskal: 将所有的边按权重排序，选择剩余的边中权重最小的边，利用并查集判断该边两侧的节点是否在同一个集合中，如果不在，就将这条边加入结果集中。
 */
public class Kruskal {
    
    // Union-Find Set
    public static class UnionFind {
        // key 某一个节点， value key节点往上的节点
        private HashMap<Node, Node> fatherMap;
        // key 某一个集合的代表节点, value key所在集合的节点个数
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node n) {
            Stack<Node> path = new Stack<>();
            while(n != fatherMap.get(n)) {
                path.add(n);
                n = fatherMap.get(n);
            }
            while(!path.isEmpty()) {
                fatherMap.put(path.pop(), n);
            }
            return n;
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aDai = findFather(a);
            Node bDai = findFather(b);
            if (aDai != bDai) {
                int aSetSize = sizeMap.get(aDai);
                int bSetSize = sizeMap.get(bDai);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aDai, bDai);
                    sizeMap.put(bDai, aSetSize + bSetSize);
                    sizeMap.remove(aDai);
                } else {
                    fatherMap.put(bDai, aDai);
                    sizeMap.put(aDai, aSetSize + bSetSize);
                    sizeMap.remove(bDai);
                }
            }
        }
    }
    
    public Set<Edge> kruskal(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodeMap.values());
        PriorityQueue<Edge> edgesPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.wigth));
        edgesPriorityQueue.addAll(graph.edgeSet);

        HashSet<Edge> edgeResult = new HashSet<>();
        while (!edgesPriorityQueue.isEmpty()) {
            Edge curEdge = edgesPriorityQueue.poll();
            if (!unionFind.isSameSet(curEdge.from, curEdge.to)) {
                edgeResult.add(curEdge);
                unionFind.union(curEdge.from, curEdge.to);
            }
        }
        return edgeResult;
    }
}
