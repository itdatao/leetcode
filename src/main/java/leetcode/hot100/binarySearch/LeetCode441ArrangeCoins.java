package leetcode.hot100.binarySearch;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode441ArrangeCoins.java
 * @Description 你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。
 * 来源：力扣（LeetCode）
 * @Date 2023-02-05 16:13:00
 */
public class LeetCode441ArrangeCoins {
    // 时间复杂度O(logN)
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
