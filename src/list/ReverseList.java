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

    /**
     * 反转单链表
     * @param head 链表头节点
     * @return 新头节点
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {//第一步，先想到遍历整个链表,所以想到使用while循环
            next = head.next;//因为反转需要将next指针指向前一个节点，但又需要不断向后遍历，所以先将下一个节点的位置保存起来
            head.next = pre;//修改next指针达到反转的目的
            pre = head;//在移动到下一个节点之前，需要记录下一个节点的前一个节点
            head = next;//来到下一个节点
        }
        return pre;//当head移动到null时，pre指向的就是最后一个节点的位置
    }


    public static class TwoWayNode {
        public int value;
        public TwoWayNode pre;
        public TwoWayNode next;
        public TwoWayNode(int value) {
            this.value = value;
        }
    }

    /**
     * 反转双向链表
     * @param head 链表头节点
     * @return 新头节点
     */
    public static TwoWayNode reverseTwoWayLinkedList(TwoWayNode head) {
        TwoWayNode pre = null;
        TwoWayNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;//最后的两条语句不可以替换为：head = next; pre = head.pre; 因为最后head会为null，则会造成空指针异常
            head = next;
        }
        return pre;
    }
}
