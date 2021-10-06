package class04;

import class02.Code03_DoubleEndsQueueToStackAndQueue;

public class Code01_Heap01 {
    public static class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit){
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }
        public boolean isEmpty(){
            return heapSize == 0;
        }

        public boolean isFull(){
            return heapSize == limit;
        }
        public void push(int value){
            if (heapSize == limit){
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }
        public int pop(){
            if (heapSize == 0){
                throw new RuntimeException("heap is empty");
            }
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }
        private void heapInsert(int[] arr, int index){
            while (arr[(index - 1)/2] < arr[index]){
                swap(arr, (index - 1)/2, index);
                index = (index - 1)/2;
            }
        }

        private void heapify(int[] arr, int index, int heapSize){
            int left = (2 * index + 1);
            while (left < heapSize){
                int largest = (left + 1 < heapSize && arr[left] < arr[left + 1]) ? left + 1 : left;
                if (arr[largest] > arr[index]){
                    swap(arr, index, largest);
                    index = largest;
                    left = (2 * index + 1);
                } else {
                    break;
                }
            }
        }

        private void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        MyMaxHeap heap = new MyMaxHeap(5);
        System.out.println(heap.isEmpty());
        heap.push(1);
        heap.push(5);
        heap.push(2);
        heap.push(6);
        heap.push(3);

        System.out.println(heap.isEmpty());
        System.out.println(heap.isFull());
        for (int i = 0; i < 5; i++){
            int x = heap.pop();
            System.out.println(x);
        }
        System.out.println(heap.isEmpty());
    }
}
