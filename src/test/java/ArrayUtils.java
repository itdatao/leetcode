import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName numayUtils.java
 * @Date 2023-02-17 14:57:00
 */
public class ArrayUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayUtils.class);

    public static void fill(int[] nums, int val) {
        Arrays.fill(nums, val);
    }

    public <T> void fill(T[][] nums, T value) {
        checkArray(nums);
        int rows = nums.length, cols = nums[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[i][j] = value;
            }
        }
    }

    public <T> void printArray(T[][] nums) {
        checkArray(nums);
        int rows = nums.length, cols = nums[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                LOGGER.info("{}", nums[i][j]);
            }
        }
    }

    private <T> void checkArray(T[] nums) {
        if (Objects.isNull(nums)) {
            throw new IllegalArgumentException("the array cannot be null!");
        }
    }
}
