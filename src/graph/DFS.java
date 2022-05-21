package graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> nextVisitStack = new Stack<>();
        HashSet<Node> visitedSet = new HashSet<>();
        nextVisitStack.push(node);
        visitedSet.add(node);
        System.out.println(node.value);
        while (!nextVisitStack.isEmpty()) {
            Node cur = nextVisitStack.pop();
            for (Node next : cur.nexts) {
                if (!visitedSet.contains(next)) {
                    System.out.println(next.value);
                    nextVisitStack.push(cur);
                    nextVisitStack.push(next);
                    visitedSet.add(next);
                    break;
                }
            }
        }
    }
}
