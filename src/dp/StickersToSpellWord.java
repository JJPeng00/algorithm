package dp;

import java.util.HashMap;

/**
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 * 您想要拼写出给定的字符串 target，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 * 返回你需要拼出 target的最小贴纸数量。如果任务不可能，则返回 -1 。
 *
 * leetcode：691. 贴纸拼词
 *
 *
 * note：这个题不能再做精细化的动态规划，因为目标字符串的变化范围太广，无法确定。
 */
public class StickersToSpellWord {

    private static int minStickers(String target, String[] stickers) {

        int stickersNums = stickers.length;
        //将每张贴纸转换为词频统计的方式
        int [][] stickersCharFrequency = new int[stickersNums][26];
        for (int i = 0; i < stickersNums; i++) {
            char[] stickerChars = stickers[i].toCharArray();
            for (char stickerChar : stickerChars) {
                stickersCharFrequency[i][stickerChar - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return process(target, stickersCharFrequency, dp);
    }

    private static int process(String target, int[][] stickersCharFrequency, HashMap<String, Integer> dp) {
        //先读缓存
        if (dp.get(target) != null) {
            return dp.get(target);
        }

        //将目标字符串也转换成词频统计的方式
        char[] targetChars = target.toCharArray();
        int[] targetCharsFrequency = new int[26];
        for (char targetChar : targetChars) {
            targetCharsFrequency[targetChar - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        //遍历每一张贴纸用来拼成目标字符串
        for (int i = 0; i < stickersCharFrequency.length; i++) {
            //确保存在一张贴纸包含目标字符串中的首字符，防止无可用贴纸而造成无限递归的栈溢出
            boolean isAValidStickerForTarget = stickersCharFrequency[i][targetChars[0] - 'a'] == 0;
            if (isAValidStickerForTarget) {
                continue;
            }

            //构建使用本贴纸后，剩下的目标字符串
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetCharsFrequency[j] > 0) {
                    for (int k = 0; k < Math.max(0, targetCharsFrequency[j] - stickersCharFrequency[i][j]); k++) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            String restTarget = sb.toString();

            int ways = process(restTarget, stickersCharFrequency, dp);
            if (ways != -1) {
                ans = Math.min(ans, 1 + ways);
            }
        }
        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        dp.put(target, ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"aaaa","bbaa","ccddd"};
        String str = "abcccccdddddbbbaaaaa";
        System.out.println(minStickers(str, arr));
    }
}
