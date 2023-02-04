package leetcode.hot100.binarySearch;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode34SearchRange.java
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Date 2023-02-04 16:21:00
 */
public class LeetCode34SearchRange {

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 来源：力扣（LeetCode）
     * 链接：<a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array">https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array</a>
     *
     * @param nums   数组
     * @param target 目标值
     * @return [firstIndex, lastIndex]
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = getRangeIndex(nums, target, true);
        res[1] = getRangeIndex(nums, target, false);
        return res;
    }

    private static int getRangeIndex(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length - 1;
        int rangeIndex = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                rangeIndex = mid;
                if (isLeft) {
                    // 所求是左边界 从右往左缩小范围
                    right = mid - 1;
                } else {
                    // 右边界 从左往右缩小边界
                    left = mid + 1;
                }
            }
        }
        return rangeIndex;
    }

    public static void main(String[] args) {

    }
}
