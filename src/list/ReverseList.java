package list;

/**
 * 反转单链表和双向链表
 */
public class ReverseList {
    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    //反转单链表
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while(head != null) {
            next = head.next;//反转前先记住下一个的位置
            head.next = pre;//反转
            pre = head;//记住当前位置，作为下一个节点反转的next
            head = next;//准备反转下一个节点
        }
        return pre;
    }


    public static class TwoWayNode {
        public int value;
        public TwoWayNode pre;
        public TwoWayNode next;
        public TwoWayNode(int value) {
            this.value = value;
        }
    }


    //反转双向链表
    public static TwoWayNode reverseTwoWayLinkedList(TwoWayNode head) {
        TwoWayNode pre = null;
        TwoWayNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;//最后的两条语句不可以替换为：head = next; pre = head.pre; 因为最后head会为null，则会造成空指针异常
            head = next;
        }
        return pre;
    }
}
