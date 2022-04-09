package list;

/**
 * 删除链表中指定值的节点
 */
public class DeleteGivenValue {
    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public Node deleteGivenNode(Node head, int target) {
        if (head == null) {
            return null;
        }
        while (head != null && head.value == target) {
            //头节点就需要被删除，并且删除后的头节点依然需要被删除
            head = head.next;
        }
        //经过以上的步骤，就确定了新链表的头节点
        Node newHead = head;
        Node pre = head;
        head = head.next;//因为head经过前面的判断已经确定不等于target了，所以继续比较后面的节点
        while (head != null) {//继续遍历，来到一个节点后，判断这个节点是否满足条件
            if (head.value == target) {//需要删除当前节点
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return newHead;
    }
}
