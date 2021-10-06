package class07;

import java.util.Stack;

public class Code02_UnRecursiveTraversalBT {
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

    public void preorderTraversal(Node root){
        if (root != null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root);
                if (root.right != null){
                    stack.push(root.right);
                }
                if (root.left != null){
                    stack.push(root.left);
                }
            }
        }
        System.out.println();
    }

    public static void inoderTraversal(Node root){
        if (root != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null){
                if (root != null){
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root);
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    public static void postorderTraversal1(Node root){
        if (root != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()){
                root = stack1.pop();
                stack2.push(root);
                if (root.left != null){
                    stack1.push(root.left);
                }
                if (root.right != null){
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()){
                root = stack2.pop();
                System.out.print(root);
            }
        }
        System.out.println();
    }

    public static void postorderTraversal2(Node root){
        if (root != null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            Node prePrintNode = null;
            Node curNode = root;
            while (!stack.isEmpty()){
                curNode = stack.peek();
                if (curNode.left != null && prePrintNode != curNode.left && prePrintNode != curNode.right){
                    stack.push(curNode.left);
                } else if (curNode.right != null && prePrintNode != curNode.right){
                    stack.push(curNode.right);
                } else {
                    System.out.print(stack.pop());
                    prePrintNode = curNode;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        inoderTraversal(head);
        postorderTraversal1(head);
        postorderTraversal2(head);
    }
}
