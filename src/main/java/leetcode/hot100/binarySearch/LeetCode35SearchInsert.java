package leetcode.hot100.binarySearch;

public class LeetCode35SearchInsert {
    // 给定一个有序数组 返回目标值所在的下标，如果目标值不存在就返回按顺序插入的位置
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
