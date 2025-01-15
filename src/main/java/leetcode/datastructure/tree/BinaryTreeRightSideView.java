package main.java.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/binary-tree-right-side-view/
 ****************************/

public class BinaryTreeRightSideView {

    //1.Each depth of the tree only select one node.
    //2. View depth is current size of result list.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
