package leetcode.hot100.dynamic;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode647CountSubString.java
 * @Description 统计回文子串的数目
 * @Date 2023-02-10 20:41:00
 */
public class LeetCode647CountSubString {
    // https://leetcode.cn/problems/palindromic-substrings/ 时间复杂度：O(n^2)，空间复杂度：O(n^2)
    public int countSubstrings(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        boolean[][] dp = new boolean[n][n];
        int result = 0;
        // 从下往上，从左往右遍历，dp[i][j] = true 表示字符串s从i至j是回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (array[i] == array[j] && (j -i <= 1 || dp[i+1][j-1])) {
                    result++;
                    dp[i][j] = true;
                }
            }
        }
        return result;
    }

    // 第二种采用中间节点向左右发散的方式统计
    public int countSubString(String s) {
        char[] array = s.toCharArray();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            // 长度为奇数时 以i为中间节点向左右两边扩散
            result += count(array, i, i);
            // 长度为偶数时，以i和i+1两个节点为中心点向左右两边扩散
            result += count(array, i, i+1);
        }
        return result;
    }

    public int count(char[] array, int i, int j) {
        int n = array.length, res = 0;
        while (i >= 0 && j < n && array[i] == array[j]) {
            i--;
            j++;
            res++;
        }
        return res;
    }
}
