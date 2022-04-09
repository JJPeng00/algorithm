package greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串str，只由‘X’和‘.’两种字符构成。
 *
 * ‘X’表示墙，不能放灯，也不需要点亮
 *
 * ‘.’表示居民点，可以放灯，需要点亮
 *
 * 如果灯放在i位置，可以让i-1，i和i+1三个位置被点亮
 *
 * 返回如果点亮str中所有"."的位置，至少需要几盏灯？
 */
public class LightGame {

    public static int light(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        return lightFully(str.toCharArray(),0, new HashSet<>());
    }

    private static int lightFully(char[] chars, int index, Set lights) {
        if (index == chars.length) {//如果所有的位置都进行了选择，那么就在这最后的时刻统计一下满足条件的情况下点亮了多少灯并返回
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 'X') {
                    if (!lights.contains(i-1) && !lights.contains(i) && !lights.contains(i+1)) {//i位置包括i附近的两个位置都没有点灯，这是不满足条件的
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {//还未结束
            //每个位置都可以选择点灯或不点灯
            int no = lightFully(chars, index + 1, lights);//index位置不点灯
            int yes = Integer.MAX_VALUE;
            if (chars[index] != 'X') {
                lights.add(index);
                yes = lightFully(chars, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);//取不点灯和点灯方案中小的那个
        }
    }

    public static int lightGreedy(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        int light = 0;
        while (index < chars.length) {
            if (chars[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == chars.length) {
                    break;
                } else {
                    if (chars[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }

    // for test
    public static String randomString(int len) {
        char[] res = new char[(int) (Math.random() * len) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.random() < 0.5 ? 'X' : '.';
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        int len = 20;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            String test = randomString(len);
            int ans1 = light(test);
            int ans2 = lightGreedy(test);
            if (ans1 != ans2) {
                System.out.println("oops!");
            }
        }
        System.out.println("finish!");
    }
}
