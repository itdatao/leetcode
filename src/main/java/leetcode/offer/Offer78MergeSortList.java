package leetcode.offer;

import leetcode.hot100.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huhuitao
 * @version 1.0.0
 * @ClassName Offer78.java
 * @Description https://leetcode.cn/problems/vvXgSW/solution/he-bing-pai-xu-lian-biao-by-leetcode-sol-w1zb/ 合并有序链表
 * @Date 2023-03-07 16:36:00
 */
public class Offer78MergeSortList {
    // 合并有序链表 归并排序，时间复杂度kn*log(k) 空间复杂度log(k)
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] nodes, int i, int j) {
        if (i == j) {
            return nodes[i];
        }
        if (i > j) {
            return null;
        }
        int mid = (i + j) >>> 1;
        return mergeNode(merge(nodes, i, mid), merge(nodes, mid + 1, j));
    }

    private ListNode mergeNode(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 != null ? node1 : node2;
        }
        ListNode head = new ListNode(0);
        ListNode tmp = head, point1 = node1, point2 = node2;

        while (point1 != null && point2 != null) {
            if (point1.val < point2.val) {
                tmp.next = point1;
                point1 = point1.next;
            } else {
                tmp.next = point2;
                point2 = point2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = point1 == null ? point2 : point1;
        return head.next;
    }

    // 合并有序链表 维护一个优先级队列，时间复杂度O(kn*log(k)) 空间复杂度O(k)
    private ListNode mergeKListNode(ListNode[] listNodes) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt((ListNode a) -> a.val));
        for (ListNode node : listNodes) {
            if (node != null) {
                priorityQueue.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }
        }
        return head.next;

    }
}
