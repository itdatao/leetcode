package leetcode.hot100;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LeetCode1001 {

    public static int alternateDigitSum(int n) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int tmp = n % 10;
            stack.push(tmp);
            n = n / 10;
        }
        int i = 1;
        while (!stack.isEmpty()) {
            int num = stack.pop() * i;
            res += num;
            i *= -1;
        }
        return res;
    }

    public static int[][] sortTheStudents(int[][] score, int k) {
        if (score == null || score.length <= 0) {
            return score;
        }
        int rows = score.length;
        int cols = score[0].length;
        int res[][] = new int[rows][cols];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            map.put(score[i][k], i);
        }
        List<Integer> list = map.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(toList());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int row = map.get(list.get(i));
                res[i][j] = score[row][j];
            }
        }

        return res;
    }

    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }

    // 最长无重复子串的长度
    public static int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(c);
                i++;
            }
            res = Math.max(res, i - left);
        }
        return res;
    }

    // 滑动窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        
        return res;
    }

    private int getMaxFromArray(int[] array) {
        return Arrays.stream(array).max().orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
//        System.out.println(alternateDigitSum(886996));
       /* int[][]nums = {{3,4},{5,6}};
        int[][] theStudents = sortTheStudents(nums, 0);
        for (int i = 0; i < theStudents.length; i++) {
            for (int j = 0; j < theStudents[0].length; j++) {
                System.out.print(theStudents[i][j] + " ");
            }
            System.out.println();
        }*/
    }
}
