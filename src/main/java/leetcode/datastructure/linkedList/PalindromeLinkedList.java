package main.java.leetcode.datastructure.linkedList;

import java.util.ArrayList;

/***************************
 * https://leetcode.com/problems/palindrome-linked-list/
 ****************************/
public class PalindromeLinkedList {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);
        System.out.println(isPalindrome(node4));
    }

    // Using Extra Space
    public static boolean isPalindromeExtraSpace(ListNode head) {
        if (head == null || head.next == null) return true;

        ArrayList<Integer> a = new ArrayList<>();
        while (head != null) {
            a.add(head.val);
            head = head.next;
        }
        int i = 0, j = a.size() - 1;
        while (i < j) {
            if (!a.get(i).equals(a.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    // Approach 2 using slow and fast pointer
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //fast node - to reach end 
        // slow node - to reach mid
        // even: fast = null and slow = mid+1
        // odd: fast = last and slow = mid
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // Now slow pointer is at mid or mid+1 and fast = last or last.next (null)
        // Let's reverse remaining half of slow
        ListNode reverse = slow, temp;
        slow = slow.next;
        reverse.next = null;

        while (slow != null) {
            temp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = temp;
        }
        // Now let's compare from slow = last and head till slow = null.

        while (reverse != null) {
            if (head.val != reverse.val) return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

}
