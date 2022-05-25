package dp;

/**
 * 字符串最长共子序列
 *
 * leetcode: 1143. 最长公共子序列
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];

        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        //先求第一列
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        //再求好第一行
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str2[j] == str1[0] ? 1 : 0);
        }

        //再算其他位置
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {

                //最长共子序列分别以i结尾和j结尾的两种情况
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                //最长共子序列以i和j位置上的值相等，即i位置上的值等于j位置上的值
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                //最长共子序列以i和j位置上的值都不相等，这种情况其实已经不必求了，
                // 因为dp[i][j - 1], dp[i - 1][j]的值一定要大于等于dp[i - 1][j - 1]位置上的值
                else {
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1]);
                }
            }
        }
        return dp[str1.length - 1][str2.length - 1];
    }

    public static void main(String[] args) {
        char[] chars1 = "abcde".toCharArray();
        char[] chars2 = "ace".toCharArray();
        System.out.println(longestCommonSubsequence(chars1, chars2));
    }
}
