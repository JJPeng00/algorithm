package class07;

import java.util.LinkedList;
import java.util.Queue;

public class Code03_LevelTraversal {
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return  value + " ";
        }
    }
    public static void levelTraversal(Node root){
        if (root != null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                root = queue.poll();
                System.out.print(root);
                if (root.left != null){
                    queue.add(root.left);
                }
                if (root.right != null){
                    queue.add(root.right);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        levelTraversal(root);
    }
}
