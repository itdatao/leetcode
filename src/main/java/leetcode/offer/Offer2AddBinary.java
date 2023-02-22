package leetcode.offer;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName Offer2AddBinary.java
 * @Description 二进制加法模拟
 * @Date 2023-02-21 21:10:00
 */
public class Offer2AddBinary {
    public static String addBinary(String a, String b) {
        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = array1.length - 1, j = array2.length - 1, c = 0;
        for (; i >= 0 || j >= 0 || c != 0; i--, j--) {
            int m = i >= 0 ? array1[i] - '0' : 0;
            int n = j >= 0 ? array2[j] - '0' : 0;
            sb.append(((m ^ n) + c) % 2);
            c = (m + n + c) / 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
