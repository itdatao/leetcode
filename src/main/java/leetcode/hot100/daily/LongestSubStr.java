package leetcode.hot100.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LongestSubStr.java
 * @Description https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
 * @Date 2023-02-28 12:12:00
 */
public class LongestSubStr {
    // 无重复字符的最长子串 输入: s = "abcabcbb"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0, left = 0;
        int len = s.length();
        char[] ss = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(ss[i])) {
                set.remove(ss[i]);
                left++;
            } else {
                set.add(ss[i]);
                maxLength = Math.max(maxLength, i - left);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
