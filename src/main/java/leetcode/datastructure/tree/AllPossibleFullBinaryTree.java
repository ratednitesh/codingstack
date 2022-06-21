package main.java.leetcode.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***************************
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 *
 *  #DP
 ****************************/
public class AllPossibleFullBinaryTree {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0)
            return res;
        if (dp.containsKey(n))
            return dp.get(n);
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 1; i < n; i = i + 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode nn = new TreeNode(0);
                    nn.left = l;
                    nn.right = r;
                    res.add(nn);
                }
            }
        }
        dp.put(n, res);
        return res;
    }
}
