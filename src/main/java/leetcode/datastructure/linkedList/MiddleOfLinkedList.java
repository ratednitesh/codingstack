package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/middle-of-the-linked-list/
 ****************************/
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        System.out.println(middleNode(node5));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
}
