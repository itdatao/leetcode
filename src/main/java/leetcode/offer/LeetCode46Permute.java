package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode46Permute.java
 * @Description 全排列
 * @Date 2023-03-20 16:08:00
 */
public class LeetCode46Permute {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    private void backtracking(int[] nums, boolean[] used) {
        // 如果每个叶子节点中的集合个数等于数组长度，表示排列完成加入到结果集中
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 排列和子集，分割字符串，子序列问题不一样的是不需要startIndex，每次都从头开始
        for (int i = 0; i < nums.length; i++) {
            // used数组，其实就是记录此时path⾥都有哪些元素使⽤了，⼀个排列⾥⼀个元素只能使⽤⼀次
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


}
