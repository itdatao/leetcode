package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName Offer80combine.java
 * @Date 2023-03-17 18:08:00
 */
public class Offer80combine {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     */
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    private void dfs(int n, int k, int start) {
        // 组合元素的个数满足时，添加到结果集中返回
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 剪枝
        for (int j = start; j <= n - (k- list.size()) + 1; j++) {
            list.add(j);
            dfs(n, k, j + 1);
            list.remove(list.size() - 1);
        }

    }
}
