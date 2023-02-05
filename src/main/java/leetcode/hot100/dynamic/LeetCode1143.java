package leetcode.hot100.dynamic;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode1143.java
 * @Description 最长公共子序列
 * @Date 2023-02-05 15:48:00
 */
public class LeetCode1143 {
    /**
     * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     * 来源：力扣（LeetCode）
     * 链接：<a href="https://leetcode.cn/problems/longest-common-subsequence">https://leetcode.cn/problems/longest-common-subsequence</a>
     *
     * 单个数组或者字符串要用动态规划时，可以把动态规划 dp[i] 定义为 nums[0:i] 中想要求的结果；当两个数组或者字符串要用动态规划时，
     * 可以把动态规划定义成两维的 dp[i][j]，其含义是在 A[0:i] 与 B[0:j]之间匹配得到的想要的结果。
     * 时间复杂度 O(m*n)
     * 空间复杂度 O(m*n)
     *
     * <a href="https://leetcode.cn/problems/longest-common-subsequence/solution/1143-zui-chang-gong-gong-zi-xu-lie-dong-zde2v/">子序列相关题目：</a>}
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 字符串1和2的最长公共子序列的长度
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        int m = text1Array.length, n = text2Array.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1Array[i - 1] == text2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int commonSubsequenceLength = longestCommonSubsequence("abc", "bc");
        System.out.println(commonSubsequenceLength);
    }
}
