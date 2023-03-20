package leetcode.exam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName huawei interview code
 * @Date 2023-03-16 15:58:00
 */
public class Exam {


    /**
     * 题目描述：
     * 给定一个字符串s，s包含以空格分隔的若干个单词，请对s进行如下处理后输出：
     * 1、单词内部调整：对每个单词字母重新按字典序排序；
     * 2、单词间顺序调整：
     * 1）统计每个单词出现的次数，并按次数降序排列；
     * 2）次数相同时，按单词长度升序排列；
     * 3）次数和单词长度均相同时，按字典序升序排列。
     * 请输出处理后的字符串，每个单词以一个空格分隔。
     * 输入描述：
     * 一行字符串，每个字符取值范围：[a-zA-Z0-9]以及空格，字符串长度范围：[1, 1000]
     * 输出描述：
     * 重新排序后的字符串，每个单词间隔1个空格，且首尾无空格
     * <p>
     * 示例1
     * 输入：
     * This is an apple
     * 输出：
     * an is This aelpp
     * <p>
     * 示例2
     * 输入：
     * My sister is in the house not in the yard
     * 输出：
     * in in eht eht My is not adry ehosu eirsst
     */
    public static String handleString(String s) {
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String split : splits) {
            char[] chs = split.toCharArray();
            Arrays.sort(chs);
            String ss = new String(chs);
            list.add(ss);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        List<String> result = list.stream().sorted((s1, s2) -> {
            int o2 = map.get(s2);
            int o1 = map.get(s1);
            if (o1 != o2) {
                return o2 - o1;
            }
            int len1 = s1.length(), len2 = s2.length();
            if (len1 != len2) {
                return len1 - len2;
            }
            return s1.compareTo(s2);
        }).collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 2、给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * <p>
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     */
    public static int maxSubLen(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        char[] array = s.toCharArray();
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                left = Math.max(left, map.get(array[i]) + 1);
            }
            map.put(array[i], i);
            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }

    // 示例 1：输入：01-02-03-04-05-06 输出：true 示例 2 输入：AA-02-03-04-05:06 输出：false
    private static Boolean isValidMacAddress(String macAddress) {
        // 0-9 a-z A-Z  中间用- :分割
        String[] splits = macAddress.split("-");
        String[] split2 = macAddress.split(":");
        if (split2.length != 6 || splits.length != 6) {
            return false;
        }
        for (String s : splits) {
            if (s.length() != 2) {
                return false;
            }
        }
        for (String s : split2) {
            if (s.length() != 2) {
                return false;
            }
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < macAddress.length(); i++) {
            char c = macAddress.charAt(i);
            if (c == ':' && set.contains('-')) {
                return false;
            }
            if (c == '-' && set.contains(':')) {
                return false;
            }
            if (c == ':' || c == '-') {
                set.add(c);
                continue;
            }
            if (!Character.isDigit(c) && !((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 问题描述： 求两个字符串 str1 和 str2 的"最长的"、"公共的"子字符串。
     * <p>
     * String str1 = "abc@12345%abcd";
     * String str2 = "abc%12345@abcd";
     * <p>
     * 预期结果： 输出12345 （因为长度是最长的5， 比abcd 长）。
     * ============================================================
     * main() {
     * // 不需要从控台获取输入，直接写死：
     * String str1 = "abc@12345%abcd";
     * String str2 = "abc%12345@abcd";
     * <p>
     * String result = getMaxSubstring(str1, str2);
     * <p>
     * // 打印出result 结果
     * System.out.println("result = " + result);
     * }
     * <p>
     * <p>
     * String getMaxSubstring(String str1, String str2) {
     * String result;
     * <p>
     * return result;
     * }
     */

    public static String getMaxSubString(String str1, String str2) {
        //异常处理
        if (str1 == null || str2 == null)
            return str1 == null ? str2 : str1;
        //动态规划
        int len1 = str1.length(),
                len2 = str2.length(),
                max = 0,
                index = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++){
            for (int j = 0; j < len2; j++){
                //如果字符相等，则这个子串的长度取决于之前的子串长度 + 1
                if (str1.charAt(i) == str2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                if (max < dp[i + 1][j + 1]){
                    max = dp[i + 1][j + 1];
                    index = i + 1;
                }
            }
        }
        //截取字符串并返回
        return max == 0 ? "-1" : str1.substring((index - max),(index));

    }


    public static void main(String[] args) {
        String string1 = "This is an apple";
        String string2 = "My sister is in the house not in the yard";
        System.out.println(handleString(string1));
        System.out.println(handleString(string2));


        System.out.println(maxSubLen("abba"));
        System.out.println(maxSubLen("bbbbb"));
        System.out.println(maxSubLen("pwwkew"));

        String s3 = "AA-02-03-04-05-08-09";
        String s4 = "01-02-03-04-05:06";
        System.out.println(isValidMacAddress(s3));
        System.out.println(isValidMacAddress(s4));

        String str1 = "12345%abcd";
        String str2 = "abc%12345@abcd";
        System.out.println(getMaxSubString(str1, str2));


        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String version1 = s1.substring(s1.indexOf("=")+1);
        String s2 = scanner.nextLine();
        String version2 = s2.substring(s2.indexOf("=")+1);
        System.out.println(compareVersion(version1, version2));
    }



    public static int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

}
