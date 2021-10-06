package class06;

import java.security.PublicKey;
import java.util.ArrayList;

public class Code03_SmallerEqualBigger {
    static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static Node process1 (Node head, int num){
        if (head == null || head.next == null){
            return head;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        partition(list, num);
        for (int i = 0; i < list.size() - 1; i++){
            list.get(i).next = list.get(i+1);
        }
        head = list.get(0);
        list.get(list.size() - 1).next = null;
        return head;
    }

    private static void partition(ArrayList<Node> list, int num) {
        int less = -1;
        int more = list.size();
        int index = 0;
        while (index < more){
            if (list.get(index).val < num){
                swap(list, index++, ++less);
            } else if (list.get(index).val == num){
                index++;
            } else {
                swap(list, index, --more);
            }
        }
    }

    private static void swap(ArrayList<Node> list, int i, int j) {
        Node temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static Node process2(Node head, int num){
        if (head == null || head.next == null){
            return head;
        }
        Node SH = null;
        Node ST = null;
        Node EH = null;
        Node ET = null;
        Node MH = null;
        Node MT = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.val < num){
                if (SH == null){
                    SH = ST = head;
                } else {
                    ST.next = head;
                    ST = head;
                }
            } else if (head.val == num){
                if (EH == null){
                    EH = ET = head;
                } else {
                    ET.next = head;
                    ET = head;
                }
            } else {
                if (MH == null){
                    MH = MT = head;
                } else {
                    MT.next = head;
                    MT = head;
                }
            }
            head = next;
        }

        //串连三个链表
        if (ST != null){
            ST.next = EH;
            ET = ET == null ? ST : ET;
        }
        if (ET != null){
            ET.next = MH;
        }
        return SH != null ? SH : (EH != null ? EH : MH);
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
//        Node head = process1(head1, 5);
        Node head = process2(head1, 5);
        while (head != null){
            System.out.println(head);
            head = head.next;
        }
    }
}
