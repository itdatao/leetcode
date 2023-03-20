package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode131Paration.java
 * @Description 分割回文子串
 * @Date 2023-03-18 12:30:00
 */
public class LeetCode131Paration {
    private final List<List<String>> result = new ArrayList<>();
    private final List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return result;
    }

    private void dfs(String s, int i) {
        if (i >= s.length()) {
            result.add(new ArrayList(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            // 验证[i, j]是否是回文串 如果是 加入到集合中 不是continue
            String subStr = s.substring(i, j+1);
            if (!isPalindrome(subStr)) {
                continue;
            }

            list.add(subStr);
            dfs(s, j+1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
