package leetcode.hot100.binarySearch;

// 二分查找有序数组中的目标值
public class LeetCode704BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int targetIndex = new LeetCode704BinarySearch().search(nums, 9);
        System.out.println(targetIndex);
    }
}
