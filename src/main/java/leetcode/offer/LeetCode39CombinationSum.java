package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode39CombinationSum.java
 * @Description https://leetcode.cn/problems/combination-sum/
 * @Date 2023-03-18 11:55:00
 */
public class LeetCode39CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    /**
     * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates
     * 中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为target 的不同组合数少于 150 个
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, target, 0, candidates);
        return result;
    }

    private void dfs(int sum, int target, int startIndex, int[] candidates) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            dfs(sum, target, i, candidates);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
