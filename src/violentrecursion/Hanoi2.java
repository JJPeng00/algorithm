package violentrecursion;

public class Hanoi2 {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    public static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
            return;
        }
        func(n - 1, from, other, to);
        System.out.println("move " + n +" from " + from + " to " + to);
        func(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
