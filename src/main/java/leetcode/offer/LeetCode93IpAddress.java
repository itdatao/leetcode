package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode93IpAddress.java
 * @Description 复原IP地址
 * @Date 2023-03-20 14:40:00
 */
public class LeetCode93IpAddress {
    List<String> result = new ArrayList<>();
    List<String> list = new ArrayList<>();

    /**
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，
     * 返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.'
     * 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     * <a href="https://leetcode.cn/problems/restore-ip-addresses/">https://leetcode.cn/problems/restore-ip-addresses/</a>
     * @param s 输入一个纯数字字符串
     * @return 返回所有合法的IP地址
     */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        // 如果字符串长度小于4，或者字符串长度大于最大值直接返回空集合
        if (len <= 3 || len >= 13) {
            return result;
        }
        dfs(s, 0);
        return result;
    }

    private void dfs(String s, int index) {
        int len = s.length();
        int size = list.size();
        if (size == 4) {
            // 分割成4个段并且是最后一个分割位点 加入到结果集中
            if (index == len) {
                result.add(String.join(".", list));
            } else {
                return;
            }
        }
        for (int i = index; i < len; i++) {
            if (!isValid(s, index, i)) break;
            String str = s.substring(index, i + 1);
            list.add(str);
            dfs(s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0不能作为IP段的开头
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            // 每个数字必须合法
            if (c > '9' || c < '0') {
                return false;
            }
            num = num * 10 + (c - '0');
            //每个分段不能大于255
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
