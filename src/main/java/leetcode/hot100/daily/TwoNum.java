package leetcode.hot100.daily;

import leetcode.hot100.ListNode;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName TwoNum.java
 * @Description 两个链表相加 <a href="https://leetcode.cn/problems/add-two-numbers/">https://leetcode.cn/problems/add-two-numbers/</a>
 * @Date 2023-02-27 21:06:00
 */
public class TwoNum {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     * @param l1
     * @param l2
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int sum = l1Value + l2Value + carry;
            carry = sum > 9 ? 1 : 0;
            // 取余表示当前位相加的值
            ListNode listNode = new ListNode(sum % 10);
            cur.next = listNode;
            cur = listNode;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

        }
        return root.next;
    }
}
