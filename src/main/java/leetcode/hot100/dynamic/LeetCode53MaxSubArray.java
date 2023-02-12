package leetcode.hot100.dynamic;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode53MaxSubArray
 * @Description 最大子数组和 https://leetcode.cn/problems/maximum-subarray/
 * @Date 2023-02-12 19:43:00
 */
public class LeetCode53MaxSubArray {
    // 找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 时间复杂度O(n)，空间复杂度O(1)
    public int maxSubArr(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }


    // 动态规划 dp[i]:表示以i结尾的子数组的最大和,i==0 dp[0]=nums[0]; i > 0,dp[i] = max(dp[i - 1] + nums[i], nums[i])
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxSubArraySum = dp[0];
        for(int i=1; i< nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            maxSubArraySum = Math.max(maxSubArraySum, dp[i]);
        }
        return maxSubArraySum;
    }
}
