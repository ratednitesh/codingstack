package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 ****************************/
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(1, node3);
        ListNode node5 = new ListNode(1, node4);
        System.out.println(deleteDuplicates(node5));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else
                curr = curr.next;
        }
        return head;
    }
}
