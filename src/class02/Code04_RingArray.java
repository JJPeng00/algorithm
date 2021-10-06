package class02;

public class Code04_RingArray {
    public static class MyQueue<T>{
        private int[] arr;
        private int pushPointer;
        private int popPointer;
        private int size;
        private final int limit;

        public MyQueue(int limit){
            arr = new int[limit];
            pushPointer = 0;
            popPointer = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int val){
            if (size == limit){
                throw new RuntimeException("队列满了，不能再push了");
            }
            size++;
            arr[pushPointer] = val;
            pushPointer = nextIndex(pushPointer);
        }

        public int pop(){
            if (size == 0){
                throw new RuntimeException("队列空了，不能再pop了");
            }
            size--;
            int ans = arr[popPointer];
            popPointer = nextIndex(popPointer);
            return ans;
        }
        private int nextIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}
