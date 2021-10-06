package class02;

import java.util.Stack;

public class Code05_GetMinStack {
    //以空间换时间的实现
    public class MyStack1{
        Stack<Integer> stackData;
        Stack<Integer> stackMin;

        public MyStack1(){
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int val){
            stackData.push(val);
            if (stackMin.isEmpty()){
                stackMin.push(val);
            } else {
                if (val < stackMin.peek()){
                    stackMin.push(val);
                } else {
                    stackMin.push(stackMin.peek());
                }
            }
        }
        public int pop(){
            stackMin.pop();
            return stackData.pop();
        }
        public int getMin(){
            return stackMin.peek();
        }
    }

    //以时间换空间，弹出时也需要比较min栈的栈定与弹出值的大小
    public class MyStack2{
        Stack<Integer> stackData;
        Stack<Integer> stackMin;

        public MyStack2(){
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int val){
            stackData.push(val);
            if (stackMin.isEmpty()){
                stackMin.push(val);
            } else {
                if (val < stackMin.peek()){
                    stackMin.push(val);
                }
            }
        }

        public int pop(){
            if (stackData.peek() < stackMin.peek()){
                stackMin.pop();
            }
            return stackData.pop();
        }

        public int getMin(){
            return stackMin.peek();
        }
    }
}
