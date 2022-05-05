package main.java.leetcode.datastructure.linkedList;

/***************************
 *
 ****************************/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode n3 = new ListNode(9);
        ListNode n2 = new ListNode(9, n3);
        ListNode n1 = new ListNode(1, n2);

//        ListNode n6 = new ListNode(4);
//        ListNode n5 = new ListNode(6, n6);
        ListNode n4 = new ListNode(9, null);

        ListNode result = addTwoNumbers(n4, n1);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(carry % 10);
            carry /= 10;
            curr = curr.next;
        }
        return head.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

