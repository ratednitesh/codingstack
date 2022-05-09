package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 ****************************/
public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(1, node3);
        ListNode node5 = new ListNode(1, node4);
        System.out.println(deleteDuplicates(node5));
    }

    // two pointer approach - fast node : track last element of dups; slow : tracks first element of dups
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode fast = head;
        ListNode slow = fakeHead;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) { // dups detected
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return fakeHead.next;
    }
}
