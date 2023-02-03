package leetcode.hot100;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class LeetCode42 {

    public int trap(int[] height) {
        // 找到最大值以及它的下标
        // 找到最大值下标左边的最大值leftMax 如果当前遍历的值小于leftMax water+=leftMax-curHeight 如果大于则更新leftMax,右侧同理
        int maxHeight = 0, maxIndex = 0, water = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        int leftMax = height[0];
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water += leftMax - height[i];
            }

        }
        int rightMax = height[height.length - 1];
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water += rightMax - height[i];
            }

        }
        return water;
    }

}
