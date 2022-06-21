package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 ****************************/
public class BinaryToInteger {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num *= 2;
            num += head.val;
            head = head.next;
        }
        return num;
    }
}
