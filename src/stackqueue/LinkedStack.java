package stackqueue;

/**
 * 使用双向链表实现栈
 * 1. 先构造双向链表节点
 * 2. 定义一个栈，包含push和pop方法
 */
public class LinkedStack {
    public static class Node {
        public int value;
        public Node pre;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class MyLinkedStack {
        private Node top;//因为栈是一种后进先出结构，只需要从一端进行操作，所以我们只需要记录top节点的位置就可以操作整个栈

        public MyLinkedStack() {
            this.top = null;
        }

        public void push(int value) {
            if (top == null) {
                top = new Node(value);
            } else {
                Node node = new Node(value);
                node.pre = top;
                top.next = node;
                top = node;
            }
        }

        /**
         * 因为当栈中没有元素时，需要返回null，所以返回值类型为Integer
         *
         * @return
         */
        public Integer pop() {
            Integer res = null;
            if (top != null) {
                res = top.value;
                if (top.pre == null) {//注意栈中只有一个节点的情况
                    top = null;
                } else {
                    top = top.pre;
                    top.next = null;//只要一个节点没有被引用，就会被GC清理掉
                }
            }
            return res;
        }
    }
}
