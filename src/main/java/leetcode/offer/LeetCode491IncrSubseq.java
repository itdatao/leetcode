package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode491IncrSubseq.java
 * @Description 递增子序列 https://leetcode.cn/problems/non-decreasing-subsequences/
 * @Date 2023-03-20 15:49:00
 */
public class LeetCode491IncrSubseq {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int start) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        // i=start Indicates that the elements in the array are not reusable
        for (int i = start; i < nums.length; i++) {
            // if current num less than last || current num have used continue
            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || used[nums[i] + 100] == 1) {
                continue;
            }
            // mark this num have used
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
