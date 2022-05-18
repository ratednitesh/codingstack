package main.java.leetcode.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 ****************************/
public class PopulatingNextRightPointer {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
        System.out.println(connect3(t));
    }

    // Approach using BFS
    public static TreeNode connect(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i < size - 1)
                    current.next = queue.peek();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return root;
    }

    // Approach using DummyHead
    public static TreeNode connect2(TreeNode root) {
        // The logic:
        // For each level, use a pre node which points to dummyHead
        // for each pre Node point the left node as next if not null.. else right node
        // point to other leg using head = head.next
        // if on the right leg, head == null.. point to next level
        TreeNode dummyHead = new TreeNode(1); //  used to reset pre Node after every level
        // In each iteration dummyHead.next will always point to first non-nullable head.
        // Explanation below.
        TreeNode pre = dummyHead; // pre node for every level: pre.next = left ideally
        TreeNode head = root; // root saved for returning
        while (head != null) {
            if (head.left != null) {
                pre.next = head.left;
                pre = pre.next;
            }
            if (head.right != null) {
                pre.next = head.right;
                pre = pre.next;
            }
            head = head.next; // If on the left leg, move to the right leg
            // OR to the sibling of head .. if no sibling, head = null!
            if (head == null) { // reached the end of level
                pre = dummyHead; // reset pre to dummyHead for new level
                head = dummyHead.next; // This moves to first non null node in the next level
                // Explanation: when pre = dummyHead , pre.next = head.left if left not null
                // considering head.left was not null .. thus moving to first non-null child of
                // original head. If head.left was null, we move to head.right
                // if it was null as well, we move to sibling head by line 35 and
                // pre.next = siblingHead.left if it was not null
                // In the last level all child were null, so head is set to null as well thus break the
                // loop
                dummyHead.next = null; // Reset DummyHead else will fall in infinite loop
            }
        }
        return root;
    }

    // Rewriting approach 2 for perfect binary tree | Optimal | beats 100%
    public static TreeNode connect3(TreeNode root) {
        if (root == null) return null;
        TreeNode head = root; // saved for returning
        TreeNode pre = head; // pre is the first left node of every level
        while (head.left != null) {
            head.left.next = head.right;
            if (head.next != null) { // if right siblings of current head exists
                head.right.next = head.next.left;
            }

            head = head.next;
            if (head == null) { // end of level
                pre = pre.left; // first child of first node of the current level
                head = pre;
            }
        }

        return root;
    }
}
