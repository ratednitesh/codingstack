package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 ****************************/
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n3.next = new ListNode(4);
        n3.next.next = new ListNode(5);
        System.out.println(removeNthFromEndSF(n1, 5));
    }

    // Approach 1: Basic Approach
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        int size = 0;
        while (root != null) {
            root = root.next;
            size++;
        }
        int i = 1;
        root = head;
        ListNode prev = root;
        int deleteIndex = size - n + 1;
        if (size == n) {
            return head.next;
        }
        while (i < deleteIndex) {
            prev = root;
            root = root.next;
            i++;
        }

        prev.next = root.next;
        return head;
    }

    // Approach using slow and fast nodes
    public static ListNode removeNthFromEndSF(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0);

        ListNode slow = fakeHead, fast = fakeHead;
        fakeHead.next = head;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return fakeHead.next;
    }
}
