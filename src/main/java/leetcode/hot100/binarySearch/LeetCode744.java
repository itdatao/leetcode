package leetcode.hot100.binarySearch;

public class LeetCode744 {
    // 找出letters数组中第一个大于target的字符，不存在返回letters[0]
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == letters.length - 1 && letters[left] <= target) return letters[0];
        return letters[left];
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'c', 'f', 'j'}; char target = 'k';
        System.out.println(nextGreatestLetter(letters, target));
    }
}
