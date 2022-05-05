package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/merge-two-sorted-lists/
 ****************************/
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(1, node2);

        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3, node5);
        ListNode node4 = new ListNode(1, node6);

        ListNode n = mergeTwoLists(node3, node4);
        System.out.println(n);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while (list1 != null || list2 != null) {
            if (list1 != null && (list2 == null || list1.val <= list2.val)) {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return head.next;
    }
}

