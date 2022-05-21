package violentrecursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 从左到右的尝试模型
 * 字符串中所有字符的全排列，也利用大问题化小问题的方式，通过先确定好前面1个位置的排列顺序，再确定2~n位置上的顺序
 * 例题：
 * [剑指 Offer 38. 字符串的排列](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/)
 */
public class StringAllPermutations {

    public static List<String> permutationsRepeat(String s) {
        if (s == null || s.length() < 1) {
            return new LinkedList<>();
        }
        List<String> results = new LinkedList<>();
        f1(s.toCharArray(), 0, results);
        return results;
    }
    // chars[0..i-1]已经确定好的
    // chars[i...]都有机会来到i位置
    public static void f1(char[] chars, int i, List<String> results) {
        if (chars.length == i) {
            results.add(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            f1(chars, i + 1, results);
            swap(chars, i, j);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    //使用set集合去重====================================================================
    public static List<String> permutationsNoRepeat1(String s) {
        if (s == null || s.length() < 1) {
            return new LinkedList<>();
        }
        HashSet<String> results = new HashSet<>();
        f2(s.toCharArray(), 0, results);
        return new LinkedList<>(results);
    }

    private static void f2(char[] chars, int i, HashSet<String> results) {
        if (chars.length == i) {
            results.add(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            f2(chars, i + 1, results);
            swap(chars, i, j);
        }
    }


    //分支限界思想====================================================================
    public static List<String> permutationsNoRepeat2(String s) {
        if (s == null || s.length() < 1) {
            return new LinkedList<>();
        }
        List<String> results = new LinkedList<>();
        f3(s.toCharArray(), 0, results);
        return results;
    }

    private static void f3(char[] chars, int i, List<String> results) {
        if (i == chars.length) {
            results.add(String.valueOf(chars));
            return;
        }
        //分支限界思想：如果某个分支之前出现过，那这条分支就到此结束，不再继续向下递归
        // 记录下i位置之前选择过哪些值，因为之前这里都是小写英文字母，那么a-a=0，即，如果a被选择过，那0位置就设置为true
        boolean[] chosen = new boolean[26];
        for (int j = i; j < chars.length; j++) {
            if (!chosen[chars[j] - 'a']) {
                chosen[chars[j] - 'a'] = true;
                swap(chars, i, j);
                f3(chars, i + 1, results);
                swap(chars, i, j);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aac";
        List<String> ans1 = permutationsRepeat(s);
        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans2 = permutationsNoRepeat1(s);
        for (String str : ans2) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans3 = permutationsNoRepeat2(s);
        for (String str : ans3) {
            System.out.println(str);
        }
    }

}
