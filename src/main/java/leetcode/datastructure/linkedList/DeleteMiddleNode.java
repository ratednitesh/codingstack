package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 ****************************/
public class DeleteMiddleNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        System.out.println(deleteMiddle(node5));
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head, secondMiddle = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            secondMiddle = slow;
            slow = slow.next;
        }
        secondMiddle.next = slow.next;
        return head;
    }
}
