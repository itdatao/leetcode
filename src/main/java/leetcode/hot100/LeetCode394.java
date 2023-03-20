package leetcode.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName LeetCode394.java
 * @Description 字符串编码
 * @Date 2023-03-06 21:39:00
 */
public class LeetCode394 {

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        int count = 0;
        Deque<Integer> digit = new ArrayDeque<>();
        Deque<StringBuilder> characters = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                // 数字和字符入栈
                digit.push(count);
                characters.push(result);
                result = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                int len = digit.pop();
                StringBuilder ch = characters.pop();
                for (int j = 0; j < len; j++) {
                    ch.append(result);
                }
                result = ch;
            } else if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
