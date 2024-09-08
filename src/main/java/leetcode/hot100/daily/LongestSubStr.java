package leetcode.hot100.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

        char[] uniqueChars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // 如果遇到窗口中重复的字符
            // 移动左边界
            if (map.containsKey(uniqueChars[i])) {
                left = Math.max(left, map.get(uniqueChars[i]) + 1);
            }

            map.put(uniqueChars[i], i);
            maxLength = Math.max(maxLength, i - left + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
