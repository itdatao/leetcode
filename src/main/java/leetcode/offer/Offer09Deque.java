package leetcode.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof">https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof</a>
 */
public class Offer09Deque {
    private static final Logger logger = LoggerFactory.getLogger(Offer09Deque.class);
    //用两个栈实现队列
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        int value = cQueue.deleteHead();
        logger.info("queue head value:{}", value);

    }
}

class CQueue {
    private final Deque<Integer> deque1;
    private final Deque<Integer> deque2;
    public CQueue() {
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        // 队列从尾部添加元素
        deque1.push(value);
    }

    public int deleteHead() {
        // 删除队首元素，如果第二个栈不为空直接返回
        if (!deque2.isEmpty()) {
            return deque2.pop();
        }
        // 两个栈都为空返回-1
        if (deque1.isEmpty()) {
            return -1;
        }
        // 栈1不为空，栈2为空，将1中的所有元素弹出栈放入栈2中，返回栈顶元素
        while (!deque1.isEmpty()) {
            deque2.push(deque1.pop());
        }
        return deque2.pop();
    }
}
