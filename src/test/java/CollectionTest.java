import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;


public class CollectionTest {

    @Test
    public void testMap() {
        System.out.println(StringUtils.isEmpty(""));
    }

    @Test
    public void sortTest() {
        int[] nums = {3, 2, 5, 7, 12, 0};
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = nums[(l + r) >>> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < mid);
            do j--; while (nums[j] > mid);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, l, i);
        quickSort(nums, j + 1, r);
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr2.length; j++) {
                int distinct = Math.abs(arr1[i] - arr2[j]);
                if (distinct <= d) {
                    flag = -1;
                }
            }
            if (flag == 0) {
                count++;
            }
        }
        return count;
    }

}
