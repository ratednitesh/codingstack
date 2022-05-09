package main.java.leetcode.datastructure.linkedList;

/***************************
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 ****************************/
public class DeleteNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        deleteNode(node2);
        System.out.println(node5);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
