package main.java.leetcode.datastructure.tree;

/***************************
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 ****************************/
public class PopulatingNextRightPointer2 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(7);
        System.out.println(connect(t));
    }

    public static TreeNode connect(TreeNode root) {
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
}
