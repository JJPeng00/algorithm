package stackqueue;

/**
 * [622. 设计循环队列](https://leetcode-cn.com/problems/design-circular-queue/)
 * 使用循环数组实现队列
 * 方案一：根据剩余可用大小来实现
 * 1. 定义队列结构
 */
public class RingArrayQueueBasedAllowSize {
    public static class MyQueue {
        private int[] array;
        private int addPointer;//下次入队元素保存的位置
        private int pollPointer;//下次出队元素所在位置
        private int allowSize;//数组剩余可用空间大小

        public MyQueue(int size) {
            array = new int[size];
            addPointer = 0;
            pollPointer = 0;
            allowSize = size;
        }

        public void add(int value) {
            if (allowSize == 0) {
                throw new RuntimeException("队列满了");
            }
            array[addPointer] = value;
            allowSize--;
            addPointer = this.nextIndex(addPointer);
        }

        public int poll() {
            if (allowSize == array.length) {
                throw new RuntimeException("队列空了");
            }
            int res = array[pollPointer];
            allowSize++;
            pollPointer = nextIndex(pollPointer);
            return res;
        }

        private int nextIndex(int index) {
            return index == array.length - 1 ? 0 : ++index;//因为addPointer和pollPinter指针始终保持向同一个方向运动
        }
    }
}
