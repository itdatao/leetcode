package leetcode.hot100.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {
    /**
     * 滑动窗口-找到字符串中所有字母异位词
     * 题目链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
     * 示例： 输入  s=cbaebabacd,p=abc 输出结果 [0.6]
     */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = p.length() , n = s.length();
        if (n < m) {
            return result;
        }
        // 字符串s小写字母的数量
        int[] sCount = new int[26];
        // 字符串p小写字母的数量
        int[] pCount = new int[26];

        // 初始化短的字符串窗口
        for (int i = 0; i < m; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // 判断第一个窗口是否相等
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }
        // 滑动窗口 窗口大小是p的长度，窗口从m开始，每次移动一个字符
        for (int i = m; i < n; i++) {
            // 左边窗口从1开始，每次循环左移动1，恢复之前走过的值
            sCount[s.charAt(i - m) - 'a']--;
            // 右边窗口从字符串p的长度开始累加
            sCount[s.charAt(i) - 'a']++;
            if(Arrays.equals(sCount, pCount)){
                // 结果是第一个字符的下标
                result.add(i - m + 1);
            }
        }

        return result;
    }

}
