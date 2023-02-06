package leetcode.hot100.binarySearch;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode74.java
 * @Description 搜索二维矩阵中的目标值
 * @link https://leetcode.cn/problems/search-a-2d-matrix/
 * @Date 2023-02-06 16:41:00
 */
public class LeetCode74 {
    // 矩阵中每行中的整数从左到右按升序排列。
    // 每行的第一个整数大于前一行的最后一个整数。 时间复杂度O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }
}
