package class06;

import java.util.ArrayList;

public class Code01_LinkedListMid {
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
    public static Node midOrUpMidNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        //使用fast来判断结束,fast一次跳两步，但不能直接判断fast.next.next != null
        while (fast.next != null && fast.next.next != null){//因为fast.next可能为null会出现空指针异常
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrUpMidPreNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownMidPreNode(Node head){
        if (head == null || head.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node right1(Node head){
        ArrayList<Node> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get((list.size() - 1) / 2);
    }
    public static Node right2(Node head){
        ArrayList<Node> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get((list.size() / 2));
    }
    public static Node right3(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get((list.size() - 1) / 2 - 1);
    }
    public static Node right4(Node head){
        if (head == null || head.next == null){
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2 - 1);
    }
    public static void main(String[] args) {
        Node node = null;
        node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(5);
        node.next.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next.next = new Node(7);
//        node.next.next.next.next.next.next.next.next= new Node(8);


        System.out.println(midOrUpMidNode(node));
        System.out.println(right1(node));

        System.out.println(midOrDownMidNode(node));
        System.out.println(right2(node));

        System.out.println(midOrUpMidPreNode(node));
        System.out.println(right3(node));

        System.out.println(midOrDownMidPreNode(node));
        System.out.println(right4(node));

    }
}
