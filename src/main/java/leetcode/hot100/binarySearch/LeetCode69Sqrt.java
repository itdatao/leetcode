package leetcode.hot100.binarySearch;

/**
 * 求 x的平方根
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sqrtx
 */
public class LeetCode69Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        // 二分查找
        int left= 1, right = x;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
