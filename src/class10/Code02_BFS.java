package class10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code02_BFS {
    public void bfs(Node node) {
        if (node != null) {
            Queue<Node> queue = new LinkedList<>();
            HashSet<Node> set = new HashSet<>();
            queue.add(node);
            set.add(node);
            while (!queue.isEmpty()) {
                node = queue.poll();
                System.out.println(node.id);
                for (Node next : node.nexts) {
                    if (!set.contains(next)) {
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
        }
        System.out.println();
    }
}
