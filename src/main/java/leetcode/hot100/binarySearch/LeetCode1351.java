package leetcode.hot100.binarySearch;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode1351.java
 * @Description 统计有序二维数组中的负数个数
 * @link https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/
 * @Date 2023-02-06 16:57:00
 */
public class LeetCode1351 {
    // 时间复杂度O(m+n)
    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length,cols=grid[0].length;
        int i=0,j=cols-1;
        while(i<rows && j >= 0) {
            if(grid[i][j] >= 0) {
                i++;
            } else {
                j--;
                count+=(rows-i);
            }
        }
        return count;
    }
}
