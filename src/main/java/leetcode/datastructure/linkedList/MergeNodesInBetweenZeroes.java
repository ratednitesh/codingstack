package main.java.leetcode.datastructure.linkedList;

public class MergeNodesInBetweenZeroes {
    public ListNode mergeNodes(ListNode head) {

        ListNode falseHead = new ListNode(0);
        ListNode itr = falseHead;

        while (head != null) {
            if (head.val == 0 && head.next != null) {
                itr.next = new ListNode(0);
                itr = itr.next;
            } else
                itr.val += head.val;
            head = head.next;
        }

        return falseHead.next;
    }
 
    // TODO: understand below solution
    public ListNode mergeNodesTP(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), prev = dummy;
        while (head != null && head.next != null) {
            prev.next = head; // prev connects next 0 node.
            head = head.next; // head forward to a non-zero node.
            while (head != null && head.val != 0) { // traverse all non-zero nodes between two zero nodes.
                prev.next.val += head.val; // add current value to the previous zero node.
                head = head.next; // forward one step.
            }
            prev = prev.next; // prev point to the summation node (initially 0).
        }
        prev.next = null; // cut off last 0 node.
        return dummy.next;
    }
}
