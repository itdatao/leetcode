package leetcode.hot100.binarySearch;

/**
 * 有效的完全平方数
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如 sqrt 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-perfect-square
 */
public class LetCode367SquareNum {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;
        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long temp = mid * mid;

            if (temp == num) {
               return true;
            } else if (temp < num) {
                left = mid + 1;
            } else if (temp > num){
                right = mid - 1;
            }
        }
        return false;
    }
}
