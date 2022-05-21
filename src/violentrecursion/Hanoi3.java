package violentrecursion;

import java.util.Stack;
//迭代实现
public class Hanoi3 {
    public static class Record {
        public boolean finish1;//有没有做完第一步
        public int base;
        public String from;
        public String to;
        public String other;

        public Record(boolean f1, int b, String f, String t, String o) {
            finish1 = false;
            base = b;
            from = f;
            to = t;
            other = o;
        }
    }

    public static void hanoi(int N) {
        if (N < 1) {
            return;
        }
        Stack<Record> stack = new Stack<>();
        stack.add(new Record(false, N, "left", "right", "mid"));
        while (!stack.isEmpty()) {
            Record cur = stack.pop();
            if (cur.base == 1) {
                System.out.println("Move 1 from " + cur.from + " to " + cur.to);
                if (!stack.isEmpty()) {
                    stack.peek().finish1 = true;
                }
            } else {
                if (!cur.finish1) {
                    stack.push(cur);
                    stack.push(new Record(false, cur.base - 1, cur.from, cur.other, cur.to));
                } else {
                    System.out.println("Move " + cur.base + " from " + cur.from + " to " + cur.to);
                    stack.push(new Record(false, cur.base - 1, cur.other, cur.to, cur.from));
                }
            }
        }
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
