package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName Offer38DailyTemperature
 * @Description 每日温度 <a href="https://leetcode.cn/problems/iIQa4I/">https://leetcode.cn/problems/iIQa4I/</a>
 * @Date 2023-02-19 16:26:00
 */
public class Offer38DailyTemperature {
    // 根据每日 气温 列表 temperatures，重新生成一个列表，要求其对应位置的输出为：
    // 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈 栈中存放的是数组的下标，从栈底到栈顶按从大到小的顺序存放
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currTemperature = temperatures[i];
            // 如果栈不为空并且当前值大于栈顶下标对应的值，栈顶出栈，并且设置栈顶下标对应的最小升温天数
            while (!deque.isEmpty() && temperatures[deque.peek()] < currTemperature) {
                Integer prevIndex = deque.pop();
                result[prevIndex] = i - prevIndex;
            }
            deque.push(i);
        }
        return result;
    }

}
