package leetcode.hot100.binarySearch;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode33.java
 * @Description 搜索旋转数组 目标值
 * @Date 2023-02-09 14:49:00
 */
public class LeetCode33RevolveArray {
    /*在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k],
    nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
    给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
    <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">https://leetcode.cn/problems/search-in-rotated-sorted-array/</a>*/
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                // 找到目标值返回下标
                return mid;
            } else if (nums[mid] >= nums[right]) { // 2 3 4 5 6 7 1
                if (nums[left] <= target && target < nums[mid]) { // [left, mid-1]
                    right = mid - 1;
                } else { // [mid+1, right]
                    left = mid + 1;
                }
            } else { // 类似这种情况 5 6 7 1 2 3 4
                if (nums[mid] < target && target <= nums[right]) { // target 在[mid+1, right]
                    left = mid + 1;
                } else { // [left,mid-1]
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
