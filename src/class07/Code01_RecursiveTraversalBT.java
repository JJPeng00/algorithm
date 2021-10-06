package class07;

import java.util.Stack;

public class Code01_RecursiveTraversalBT {
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " ";
        }
    }
    public static void preorderTraversal(Node root){
        if (root == null){
            return;
        }
        System.out.print(root);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorderTraversal(Node root){
        if (root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root);
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root){
        if (root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("pre-order:");
        preorderTraversal(root);
        System.out.println();
        System.out.println("in-order:");
        inorderTraversal(root);
        System.out.println();
        System.out.println("post-order:");
        postorderTraversal(root);
    }
}
