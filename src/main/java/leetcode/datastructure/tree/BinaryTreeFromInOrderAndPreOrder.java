package main.java.leetcode.datastructure.tree;

/***************************
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 ****************************/
public class BinaryTreeFromInOrderAndPreOrder {
    /*The basic idea is here:
    Say we have 2 arrays, PRE and IN.
    Preorder traversing implies that PRE[0] is the root node.
    Then we can find this PRE[0] in IN, say it's IN[5].
    Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
    Recursively doing this on subArrays, we can build a tree out of it
    */
    // TODO : understand below code fully.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
