package leetcode.hot100.binarySearch;
/* 猜数字 返回猜的数字
-1：我选出的数字比你猜的数字小 pick < num
1：我选出的数字比你猜的数字大 pick > num
0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/guess-number-higher-or-lower
*/

public class LeetCode374GuessNum {
    public int guessNumber(int n) {
        int left = 0, right = n, num = n;
        while(left <= right) {
            int mid = (left + right) >>> 1;
            int res = guess(mid);
            if(res > 0){
                left = mid +1;
            } else if(res < 0) {
                right = mid - 1;
            } else {
                num = mid;
                break;
            }
        }
        return num;
    }

    private int guess(int mid) {
        return 0;
    }
}
