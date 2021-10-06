package class10;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code04_TopologySort {
    public LinkedList<Node> sort(Graph graph){
        if (graph == null) {
            return null;
        }
        HashMap<Node , Integer> inMap = new HashMap<>();
        Queue<Node> zeroInqueue = new LinkedList<>();

        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInqueue.add(node);
            }
        }
        LinkedList<Node> res = new LinkedList<>();
        while (!zeroInqueue.isEmpty()) {
            Node cur = zeroInqueue.poll();
            res.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInqueue.add(next);
                }
            }
        }
        return res;
    }
}
