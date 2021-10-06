import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Try {
    public static class Node{
        public int value;
        public Node pre;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public static class MyStack{
        private Node first;
        public MyStack() {
            first = null;
        }

        public void push(int a) {
            if (this.first == null) {
                first = new Node(a);
            } else {
                Node next = first;
                first = new Node(a);
                first.next = next;
                next.pre = first;
            }
        }

        public Integer pop() {
            Integer ans = null;
            if (first != null) {
                ans = first.value;
                if (first.next != null) {
                    first = first.next;
                    first.pre = null;
                } else {
                    first = null;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
