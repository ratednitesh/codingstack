package main.java.algo.linkedList;

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

    // TODO: incomplete code
    public static boolean isPalindrome(ListNode head) {
        return false;
    }
}
