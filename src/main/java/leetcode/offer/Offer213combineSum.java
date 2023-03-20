package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName Offer213combineSum.java
 * @Description 目标和为N的组合
 * @Date 2023-03-17 18:32:00
 */
public class Offer213combineSum {
    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, n, 1, k);
        return result;
    }

    private void dfs(int sum, int targetSum, int start, int k) {
        if (sum > targetSum) return;
        if (k == list.size()) {
            if (sum == targetSum) result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < 10; i++) {
            sum+=i;
            list.add(i);
            dfs(sum, targetSum, i+1, k);
            list.remove(list.size() - 1);
            sum-=i;
        }
    }

}
