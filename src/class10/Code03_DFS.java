package class10;

import java.util.HashSet;
import java.util.Stack;

public class Code03_DFS {
    public void dfs(Node node) {
        if (node != null) {
            Stack<Node> stack = new Stack<>();
            HashSet<Node> set = new HashSet<>();
            stack.push(node);
            set.add(node);
            System.out.println(node.id);//第一次入栈时打印，
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                for (Node next : cur.nexts) {
                    if (!set.contains(next)) {
                        stack.push(cur);
                        stack.push(next);
                        set.add(next);
                        System.out.println(next.id);
                        break;
                    }
                }
            }
        }
        System.out.println();
    }
}