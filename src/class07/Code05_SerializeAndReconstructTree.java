//package class07;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//
//public class Code05_SerializeAndReconstructTree {
//    static class Node{
//        public int value;
//        public Node left;
//        public Node right;
//        public Node(int value) {
//            this.value = value;
//        }
//    }
//
//    //前序序列化
//    public Queue<String> preSerial(Node root) {
//        Queue<String> queue = new LinkedList<>();
//        pres(root, queue);
//        return queue;
//    }
//
//    public static void pres(Node root, Queue<String> queue) {
//        if (root == null) {
//            queue.add(null);
//        } else {
//            queue.add(String.valueOf(root.value));
//            pres(root.left, queue);
//            pres(root.right, queue);
//        }
//    }
//
//    //前序反序列化
//    public static Node buildByPreQueue(Queue<String> queue){
//        if (queue == null || queue.size() == 0){
//            return null;
//        }
//        return preb(queue);
//    }
//
//    public static Node preb(Queue<String> queue){
//        String value = queue.poll();
//        if (value == null){
//            return null;
//        }
//        Node node = new Node(Integer.valueOf(value));
//        node.left = preb(queue);
//        node.right = preb(queue);
//        return node;
//    }
//
//    //后序序列化
//    public static Queue<String> posSerial(Node root){
//        Queue<String> queue = new LinkedList<>();
//        poss(root, queue);
//        return queue;
//    }
//
//    public static void poss(Node root, Queue<String> queue) {
//        if (root == null) {
//            queue.add(null);
//        } else {
//            poss(root.left, queue);
//            poss(root.right, queue);
//            queue.add(String.valueOf(root.value));
//        }
//    }
//
//    //后序反序列化
//    public static Node buildByPosQueue(Queue<String> queue){
//        if (queue == null || queue.size() == 0) {
//            return null;
//        }
//        //queue中保存的顺序是左右头，而只有从头节点开始才能构建出整棵二叉树，所以把头节点放到前面，所以可以逆序成头右左
//        Stack<String> stack = new Stack<>();
//        while (!queue.isEmpty()) {
//            stack.push(queue.poll());
//        }
//        return posb(stack);
//    }
//
//    public static Node posb(Stack<String> stack) {
//        String value = stack.pop();
//        if (value == null) {
//            return null;
//        }
//        Node node = new Node(Integer.valueOf(value));
//        node.right = posb(stack);
//        node.left = posb(stack);
//        return node;
//    }
//
//    //层次序列化
//    public static Queue<String> levelSerial(Node root) {
//
//    }
//}
