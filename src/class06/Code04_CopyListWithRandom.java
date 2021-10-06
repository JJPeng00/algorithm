package class06;

import java.util.HashMap;

public class Code04_CopyListWithRandom {
    static class Node{
        public int val;
        public Node next;
        public Node random;
        public Node(int val){
            this.val = val;
        }
    }

    public static Node process1(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        Node head1 = head;
        while (head != null){
            cur = map.get(head);
            cur.next = map.get(head.next);
            cur.random = map.get(head.random);
            head = head.next;
        }
        return map.get(head1);
    }

    public static Node process2(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        Node curCopy = null;
        while (cur != null){
            curCopy = new Node(cur.val);
            next = cur.next;
            cur.next = curCopy;
            curCopy.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null){
            curCopy = cur.next;
            curCopy.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node copyHead = cur.next;
        next = null;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return copyHead;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("random:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        Node cp = process1(head);
        printRandLinkedList(cp);
        Node cp1 = process2(head);
        printRandLinkedList(cp1);
    }
}
