package class11;

public class Code01_Hanio {
//  第一种递归实现==============================================================
    public static void hanoi01(int n){
        if (n > 0){
            leftToRight(n);
        }
    }
    public static void leftToRight(int n){
        if (n == 1) {
            System.out.println("move 1 from left to right");
        } else {
            leftToMid(n-1);
            System.out.println("move " + n + " from left to right");
            midToRight(n-1);
        }
    }
    public static void leftToMid(int n){
        if (n == 1){
            System.out.println("move 1 from left to mid");
        } else {
            leftToRight(n-1);
            System.out.println("move " + n + " from left to mid");
            rightToMid(n-1);
        }
    }
    public static void midToRight(int n){
        if (n == 1){
            System.out.println("move 1 from mid to right");
        } else {
            midToLeft(n-1);
            System.out.println("move "+ n + " from mid to right");
            leftToRight(n-1);
        }
    }
    public static void rightToMid(int n){
        if (n == 1){
            System.out.println("move 1 from right to mid");
        } else {
            rightToLeft(n-1);
            System.out.println("move " + n + " from right to mid");
            leftToMid(n-1);
        }
    }
    public static void midToLeft(int n){
        if (n == 1){
            System.out.println("move 1 from mid to left");
        } else {
            midToRight(n-1);
            System.out.println("move " + n + " from mid to left");
            rightToLeft(n-1);
        }
    }
    public static void rightToLeft(int n){
        if (n == 1){
            System.out.println("move 1 from right to left");
        } else {
            rightToMid(n-1);
            System.out.println("move " + n + " from right to left");
            midToLeft(n-1);
        }
    }
//第二种递归实现=========================================================================
    public static void hanoi02(int n){
        if (n > 0){
            func(n, "left", "right", "mid");
        }
    }
    public static void func(int n, String from, String to, String other){
        if (n == 1){
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            func(n-1, from, other, to);
            System.out.println("move "+ n +" from "+ from +" to "+ to);
            func(n-1, other, to, from);
        }
    }


    public static void main(String[] args) {
        hanoi01(3);
        System.out.println("======================");
        hanoi02(3);
    }
}
