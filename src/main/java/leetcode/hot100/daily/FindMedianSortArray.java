package leetcode.hot100.daily;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName FindMedianSortArray.java
 * @Description https://leetcode.cn/problems/median-of-two-sorted-arrays/?favorite=2cktkvj 寻找两个有序数组的中位数
 * @Date 2023-02-28 17:01:00
 */
public class FindMedianSortArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0, len = res.length;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                res[k++] = nums2[j++];
            } else {
                res[k++] = nums1[i++];
            }
        }
        while (i < nums1.length) {
            res[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            res[k++] = nums2[j++];
        }
        return len % 2 == 0 ? (res[len / 2] + res[len / 2 - 1]) / 2.0 : res[len / 2];

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,1,3,5,7,9};
        int[] nums2 = {2,4,6,8,10,12,14,16};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
