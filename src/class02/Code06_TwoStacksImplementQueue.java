package class02;

import java.util.Stack;

public class Code06_TwoStacksImplementQueue {
    public static class MyQueue{
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public MyQueue(){
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void add(int val){
            stackPush.push(val);
        }

        public int poll(){
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return  stackPop.pop();
        }

        public int peek(){
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return  stackPop.peek();
        }
    }

    public static void main(String[] args) {
        MyQueue test = new MyQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
