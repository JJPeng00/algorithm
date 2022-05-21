package violentrecursion;

/**
 * 汉诺塔问题是要将上小下大堆叠的圆盘从左移动到右边，并在这个过程中保持上小下大
 * 暴力递归：将大问题化成小问题，将n层圆盘从左移到右化成小问题就是将n-1层圆盘从左移到中间，再将第n层圆盘从左移到右，再将n-1层圆盘从中移到右
 */
public class Hanoi1 {

    public static void hanoi(int n) {
        if (n > 0) {
            leftToRight(n);
        }
    }

    public static void leftToRight(int n) {
        if (n == 1) {
            System.out.println("move 1 from left to right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("move " + n + " from left to right");
        midToRight(n - 1);
    }

    private static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("move " + n + " from left to mid");
        rightToMid(n - 1);
    }

    private static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("move " + n + " from right to mid");
        leftToMid(n - 1);
    }

    private static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("move 1 from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("move " + n + " from right to left");
        midToLeft(n - 1);
    }

    private static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("move 1 from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println("move " + n + " from mid to left");
        rightToLeft(n - 1);
    }

    private static void midToRight(int n) {
        if (n == 1) {
            System.out.println("move 1 from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("move " + n + " from mid to right");
        leftToRight(n - 1);
    }

    public static void main(String[] args) {
        hanoi(1);
    }
}
