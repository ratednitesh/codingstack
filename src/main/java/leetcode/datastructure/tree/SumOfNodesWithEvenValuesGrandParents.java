package main.java.leetcode.datastructure.tree;

/***************************
 *
 ****************************/
public class SumOfNodesWithEvenValuesGrandParents {
    // Optimized Solution
    public int sumEvenGrandparentOpt(TreeNode root) {
        return helper(root, 1, 1);
    }

    public int helper(TreeNode node, int p, int gp) {
        if (node == null) return 0;
        return helper(node.left, node.val, p) + helper(node.right, node.val, p) + (gp % 2 == 0 ? node.val : 0);
    }

    // Solution 2:  basic
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null)
                    sum += root.left.left.val;
                if (root.left.right != null)
                    sum += root.left.right.val;
            }
            if (root.right != null) {
                if (root.right.left != null)
                    sum += root.right.left.val;
                if (root.right.right != null)
                    sum += root.right.right.val;
            }
        }

        return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
