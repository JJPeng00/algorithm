package violentrecursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *子串和子序列是不同的，子串是要连续的，子序列要更自由不要求连续，但相对次序不能乱
 * 拓展：[剑指 Offer II 097. 子序列的数目](https://leetcode.cn/problems/21dk04/)
 *      可以返回以下方法中的set集合的size
 *      更好的方法是用动态规划做
 */
public class StringAllSubsequences {

    public static List<String> subsRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> results = new LinkedList<>();
        f(str, 0, results, path);
        return results;
    }

    private static void f(char[] str, int index, List<String> results, String path) {
        if (index == str.length) {
            results.add(path);
            return;
        }
        f(str, index + 1, results, path);
        f(str, index + 1, results, path + str[index]);
    }

    public static List<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> results = new HashSet<>();
        f2(str, 0, results, path);
        return new LinkedList<>(results);
    }

    private static void f2(char[] str, int index, Set<String> results, String path) {
        if (index == str.length) {
            results.add(path);
            return;
        }
        f2(str, index + 1, results, path);
        f2(str, index + 1, results, path + str[index]);
    }

    public static void main(String[] args) {
        String test = "aacc";
        List<String> ans1 = subsRepeat(test);
        List<String> ans2 = subsNoRepeat(test);

        System.out.println(ans1);
        System.out.println("==================");
        System.out.println(ans2);
    }

}
