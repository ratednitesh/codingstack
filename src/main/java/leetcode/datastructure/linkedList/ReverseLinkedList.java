package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/reverse-linked-list/
 ****************************/
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        System.out.println(reverseList(node4));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode reverse = head;
        head = head.next;
        reverse.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = reverse;
            reverse = head;
            head = temp;
        }
        return reverse;
    }
}
