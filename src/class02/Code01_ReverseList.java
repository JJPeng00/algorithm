package class02;

public class Code01_ReverseList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static Node creatLinkedList(int len){
        if (len < 1){
            return null;
        }
        Node head = new Node((int)(Math.random()*10));
        Node node = head;
        len--;
        while (len != 0){
            Node cur = new Node((int)(Math.random()*10));
            node.next = cur;
            node = cur;
            len--;
        }
        return head;
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int data){
            this.value = data;
        }
    }
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static DoubleNode creatDoubleNode(int len){
        if (len < 1){
            return null;
        }
        DoubleNode head = new DoubleNode((int)(Math.random()*10));
        DoubleNode doubleNode = head;
        len--;
        while (len != 0){
            DoubleNode cur = new DoubleNode((int)(Math.random()*10));
            doubleNode.next = cur;
            cur.pre = doubleNode;
            doubleNode = cur;
            len--;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = creatLinkedList(10);
        reverseLinkedList(head);
        DoubleNode doubleNode = creatDoubleNode(10);
        reverseDoubleList(doubleNode);
    }
}
