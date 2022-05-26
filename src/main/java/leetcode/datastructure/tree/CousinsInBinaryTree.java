package main.java.leetcode.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/cousins-in-binary-tree/
 ****************************/
public class CousinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(5);
        System.out.println(isCousins(t, 3, 2));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) //edge case
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y)
                        return false;
                    if (node.left.val == y && node.right.val == x)
                        return false;
                }
                if (node.val == x || node.val == y) {
                    while (i + 1 < size) {
                        i++;
                        int val = queue.poll().val;
                        if (y == val || x == val)
                            return true;
                    }
                    return false;
                }

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return false;
    }
}
