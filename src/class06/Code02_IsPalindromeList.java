package class06;

import java.util.Stack;

public class Code02_IsPalindromeList {
    static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
    // need n extra space
    public static boolean process1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need n/2 extra space
    public static boolean process2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            if (stack.pop().val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //need O(1) extra space
    public static boolean process3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow来到中点或上中点
        Node cur = slow.next;//first node of the right
        Node pre = slow;
        slow.next = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        Node left = head;
        Node right = pre;
        boolean ans = true;
        while (left != null){
            if (left.val != right.val){
                ans = false;
            }
            left = left.next;
            right = right.next;
        }
        right = pre;
        pre = null;
        while (right != null){
            next = right.next;
            right.next = pre;
            pre = right;
            right = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Node node = null;
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);
//        node.next.next.next.next.next = new Node(1);

        System.out.println(process1(node));
        System.out.println(process2(node));
        System.out.println(process3(node));
        while (node != null){
            System.out.println(node);
            node = node.next;
        }
    }
}
