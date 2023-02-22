package leetcode.offer;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName Offer01Divide.java
 * @Description 实现两数相除 禁用 / % *
 * @Date 2023-02-21 21:46:00
 */
public class Offer01Divide {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 4));
    }
    public static int divide(int a, int b) {
        int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE, MIN_LIMIT = MIN >> 1; // -1073741824
        if(a == MIN && b == -1) return MAX; // 特判
        boolean isPos = (a >= 0 || b <= 0) && (a <= 0 || b >= 0);
        if(a > 0) a = -a;
        if(b > 0) b = -b;
        int ans = 0; // 最终的商
        while(a <= b) {
            int d = b, c = 1; // d为当前除数，c为当前商
            while(d >= MIN_LIMIT && d + d >= a) { // 通过第一个条件防止d + d溢出
                d += d; // 当前除数倍增，也可以用 d <<= 1;
                c += c; // 当前商倍增，也可以用 c <<= 1;
            }
            a -= d; // a剩余部分
            ans += c; // 累计当前商
        }
        return isPos ? ans : -ans;
    }
}
