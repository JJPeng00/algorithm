package class11;

import java.util.*;

public class Code02_PrintAllSubsquences {
    public static List<String> subs(String string){
        char[] str = string.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }
    public static void process1(char[] str, int index, List<String> ans, String path){
        if (index == str.length){
            ans.add(path);
            return;
        }
        String yes = path + (String.valueOf(str[index]));
        process1(str,index+1, ans, yes);
        String no = path;
        process1(str, index+1, ans, no);
    }

    public static List<String> subsNoRepeat(String string){
        char[] str = string.toCharArray();
        String path = "";
        Set<String> ans = new HashSet<>();
        process2(str, 0, ans, path);
        List<String> list = new ArrayList<>();
        for (String an : ans) {
            list.add(an);
        }
        return list;
    }
    public static void process2(char[] str, int index, Set<String> ans, String path){
        if (index == str.length){
            ans.add(path);
            return;
        }
        String yes = path + (String.valueOf(str[index]));
        process2(str,index+1, ans, yes);
        String no = path;
        process2(str, index+1, ans, no);
    }

    public static void main(String[] args) {
        String string = "aacc";
        List<String> ans1 = subs(string);
        List<String> ans2 = subsNoRepeat(string);
        System.out.println(ans1);
        System.out.println("================");
        System.out.println(ans2);
    }
}
