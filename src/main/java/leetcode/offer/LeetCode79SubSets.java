package leetcode.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode79SubSets.java
 * @Description 求子集 https://leetcode.cn/problems/subsets/solution/
 * @Date 2023-03-20 15:14:00
 */
public class LeetCode79SubSets {
    private List<List<Integer>> result = new ArrayList<>();
    private Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1);
            list.removeLast();
        }
    }
}
