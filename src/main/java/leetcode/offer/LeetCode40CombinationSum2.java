package leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode40CombinationSum2.java
 * @Description https://leetcode.cn/problems/combination-sum-ii/
 * @Date 2023-03-18 12:08:00
 */
public class LeetCode40CombinationSum2 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    /**
     * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
     *
     * candidates中的每个数字在每个组合中只能使用一次。
     *
     * 注意：解集不能包含重复的组合。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(0, target, 0, candidates, used);
        return result;
    }

    private void dfs(int sum, int target, int startIndex, int[] candidates, boolean[] used) {

        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 去重
            if (i > 0 && candidates[i-1] == candidates[i] && !used[i-1]) {
                continue;
            }

            sum += candidates[i];
            list.add(candidates[i]);
            used[i] = true;
            dfs(sum, target, i + 1, candidates, used);
            list.remove(list.size() - 1);
            used[i] = false;
            sum -= candidates[i];
        }
    }



}
