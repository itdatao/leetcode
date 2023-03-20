package leetcode.hot100.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName TwoSum.java
 * @Description 两数之和
 * @Date 2023-02-27 21:01:00
 */
public class TwoSum {
    // 找出数组中两个数等于target的下标
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};

    }
}
