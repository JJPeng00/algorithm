package class02;
public class Code03_DoubleEndsQueueToStackAndQueue {
    public static class Node<T>{
        public T value;
        public Node<T> pre;
        public Node<T> next;
        public Node(T val){
            this.value = val;
        }
    }

    public static class DoubleEndsQueue<T>{
        public Node<T> first;
        public Node<T> last;

        public DoubleEndsQueue(){
            this.first = null;
            this.last = null;
        }

        public void addToFirst(T val){
            Node<T> node = new Node(val);
            if (first == null){
                first = node;
                last = node;
            } else {
                node.next = first;
                first.pre = node;
                first = node;
            }
        }
        public void addToLast(T val){
            Node<T> node = new Node<>(val);
            if (last == null){
                first = node;
                last = node;
            } else {
                last.next = node;
                node.pre = last;
                last = node;
            }
        }
        public T popFromFirst(){
            if (first == null){
                return null;
            }
            Node<T> node = first;
            if (first == last){
                first = null;
                last = null;
            } else {
                first = first.next;
                node.next = null;
                first.pre = null;
            }
            return node.value;
        }
        public T popFromLast(){
            if (last == null){
                return null;
            }
            Node<T> node = last;
            if (first == last){
                first = null;
                last = null;
            } else {
                last = last.pre;
                node.pre = null;
                last.next = null;
            }
            return node.value;
        }
        public Boolean isEmpty(){
            return first == null;
        }
    }
    public static class MyStack<T>{
        DoubleEndsQueue<T> doubleEndsQueue;

        public MyStack(){
            doubleEndsQueue = new DoubleEndsQueue<>();
        }
        public void push(T val){
            doubleEndsQueue.addToFirst(val);
        }
        public T pop(){
            return doubleEndsQueue.popFromFirst();
        }
        public Boolean isEmpty(){
            return doubleEndsQueue.isEmpty();
        }
    }
    public static class MyQueue<T>{
        DoubleEndsQueue<T> doubleEndsQueue;
        public MyQueue() {
            doubleEndsQueue = new DoubleEndsQueue<>();
        }
        public void push(T val){
            doubleEndsQueue.addToFirst(val);
        }
        public T pop(){
            return doubleEndsQueue.popFromLast();
        }
        public Boolean isEmpty() {
            return doubleEndsQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        System.out.println(myQueue.pop());
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        MyStack<String> myStack = new MyStack<>();
        System.out.println(myStack.pop());
        myStack.push("helll");
        myStack.push("world");
        myStack.push("heihei");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
