package violentrecursion;

import java.util.Stack;

/**
 * 给定一个栈，仅使用递归的方式逆序这个栈
 * 思路：将大问题化小问题，为了逆序整个大栈，可以先将其转换为逆序一个小栈的问题：可以先将1~n-1个元素的栈逆序，再将原来的栈底元素push进n-1个元素的栈
 */
public class RecursiveReverseStack {

    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int bottom = removeStackBottom(stack);
        reverse(stack);
        stack.push(bottom);
        return stack;
    }

    //这个从一个栈中返回栈底的元素x，但元素x之上的元素的依然保持原来栈的顺序
    //这依然可以利用将大问题化小问题的思路：
    //将栈顶元素弹出，就将从一个大栈中获取栈底元素的问题转换成了从一个小栈获取栈底元素的问题。
    private static int removeStackBottom(Stack<Integer> stack) {
        Integer stackTop = stack.pop();
        if (stack.isEmpty()) {
            return stackTop;
        } else {
            int stackBottom = removeStackBottom(stack);
            stack.push(stackTop);
            return stackBottom;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        System.out.println(test);
    }
}
