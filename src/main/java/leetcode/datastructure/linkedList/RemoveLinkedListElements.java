package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/remove-linked-list-elements/
 ****************************/
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(3, node4);
        System.out.println(removeElements(node5, 3));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.next == null) {
            if (head.val == val)
                return null;
            else
                return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
