package violentrecursion;

/**
 * 从做往右的尝试模型
 * 题目：[剑指 Offer 46. 把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)
 * 规定`1和A`对应，`2和B`对应，`3和C`对应...
 * 那么一个数字字符串比如`111`就可以转化为`AAA`（1,1,1）、`KA`（11,1）、`AK`（1,11）
 * 给定一个只有数字组成的字符串str，返回有多少种转化结果？
 * note：要将整个数字串完整翻译成字符串
 */
public class DigitStringConvertToLetterString {

    public static int number(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        char[] chars = str.toCharArray();
        return f1(chars, 0);
    }

    //chars[0...i-1]位置已经翻译完了，接着翻译i..n位置，如果完整翻译成字符串则为一种翻译方法
    private static int f1(char[] chars, int i) {
        if (i == chars.length) {
            //正好翻译完成，那么之前的翻译方式是一种正确的方式
            return 1;
        }
        if (chars[i] == '0') {
            //0不可翻译，所以之前的翻译方式是不正确的
            return 0;
        }
        //遇到1，可以是1~19
        if (chars[i] == '1') {
            int res = f1(chars, i + 1);
            if (i + 1 < chars.length) {
                res += f1(chars, i + 2);
            }
            return res;
        }
        //遇到2，可以是2~26
        if (chars[i] == '2') {
            //i位置的字符单独翻译，能有多少种翻译方法
            int res = f1(chars, i + 1);
            if (i + 1 < chars.length && chars[i + 1] <= '6') {
                //i和i+1位置一起翻译，能有多少种翻译方法
                res += f1(chars, i + 2);
            }
            return res;
        }
        //非1非2则只能翻译一个字符
        return f1(chars, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(number("11111"));
    }
}
