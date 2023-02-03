package leetcode.hot100;

/**
 * 合并两个链表 给你两个链表list1 和list2，它们包含的元素分别为 n个和 m 个。
 * 请你将list1中下标从 a 到 b 的全部节点都删除，并将list2接在被删除节点的位置。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-in-between-linked-lists
 */
public class LeetCode1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 找到a-1节点 找到b+1节点 找到list2的尾结点 a-1.next = list2 end2.next = b+1
        ListNode end2 = list2;
        while (end2.next != null) {
            end2 = end2.next;
        }
        ListNode prev = list1;
        for (int i = 0; i < a-1; i++) {
            prev = prev.next;
        }
        ListNode node = prev.next;
        for (int i = a; i < b + 1; i++) {
            node = node.next;
        }
        prev.next = list2;
        end2.next = node;
        return list1;
    }

}
