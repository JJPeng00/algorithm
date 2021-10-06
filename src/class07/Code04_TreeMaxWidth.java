package class07;

import com.sun.xml.internal.ws.encoding.MtomCodec;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Code04_TreeMaxWidth {
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static int maxWidthUseMap(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Map<Node,Integer> map = new HashMap<>();
        map.put(root, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            int curNodeLevel = map.get(root);
            if (root.left != null) {
                queue.add(root.left);
                map.put(root.left, curNodeLevel + 1);
            }
            if (root.right != null) {
                queue.add(root.right);
                map.put(root.right, curNodeLevel + 1);
            }

            if (curLevel == curNodeLevel){
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWidthUseFlags(Node root){
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node curLevelEndNode = root;
        Node nextLevelEndNode = null;
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.add(root.left);
                nextLevelEndNode = root.left;
            }
            if (root.right != null) {
                queue.add(root.right);
                nextLevelEndNode = root.right;
            }
            curLevelNodes++;
            if (root == curLevelEndNode) {
                max = Math.max(max, curLevelNodes);
                curLevelEndNode = nextLevelEndNode;
                curLevelNodes = 0;
            }
        }
        return max;
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWidthUseFlags(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }
}
