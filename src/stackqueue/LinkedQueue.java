package stackqueue;

/**
 * 使用双向链表实现队列
 * 1. 先构造双向链表节点
 * 2. 定义一个队列，包含add和poll方法
 */
public class LinkedQueue {

    public static class Node {
        public int value;
        public Node pre;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class MyLinkedQueue {
        private Node head;//因为队列是一个先进先出的双端结构，所以需要同时记录首尾两个节点的位置
        private Node tail;
        public MyLinkedQueue() {
            head = tail = null;
        }

        public void add(int value) {
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                Node node = new Node(value);
                tail.pre = node;
                node.next = tail;
                tail = node;
            }
        }

        public Integer poll() {
            Integer res = null;
            if (head != null) {
                res = head.value;
                if (head == tail) {
                    head = tail = null;
                } else {
                    head = head.pre;
                    head.next = null;
                }
            }
            return res;
        }
    }
}
