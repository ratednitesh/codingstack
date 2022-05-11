package main.java.leetcode.datastructure.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/sort-list/
 ****************************/
public class SortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(3, node3);
        System.out.println(sortList(node4));
    }

    public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        while (head != null) {
            pq.offer(head);
            head = head.next;
        }
        ListNode fakeHead = new ListNode();
        ListNode curr = fakeHead;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
        }
        curr.next = null;
        return fakeHead.next;
    }
    // TODO: Using merge Sort
}
