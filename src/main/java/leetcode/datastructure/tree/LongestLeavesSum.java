package main.java.leetcode.datastructure.tree;

/***************************
 * https://leetcode.com/problems/deepest-leaves-sum/
 ****************************/
public class LongestLeavesSum {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.right = new TreeNode(6);
        t.left.left.left = new TreeNode(7);
        t.right.right.right = new TreeNode(8);
        System.out.println(deepestLeavesSum(t));
    }

    static int longestLeg = 0;
    static int longestLeavesSum = 0;

    public static int deepestLeavesSum(TreeNode root) {
        findLongestLeg(root, 0);
        findLongestLegSum(root, 0);
        return longestLeavesSum;
    }

    private static void findLongestLegSum(TreeNode head, int currentCount) {
        if (head != null) {
            currentCount++;
            if (currentCount == longestLeg)
                longestLeavesSum += head.val;
            if (head.left != null)
                findLongestLegSum(head.left, currentCount);
            if (head.right != null)
                findLongestLegSum(head.right, currentCount);
        }
    }

    public static void findLongestLeg(TreeNode head, int currentCount) {
        if (head != null) {
            currentCount++;
            if (currentCount > longestLeg)
                longestLeg = currentCount;
            if (head.left != null)
                findLongestLeg(head.left, currentCount);
            if (head.right != null)
                findLongestLeg(head.right, currentCount);
        }
    }

    // Approach 2: Enhanced Solution
    private static int maxLevel = 0;
    private static int sum = 0;

    public int deepestLeavesSumOptimized(TreeNode root) {
        if (root == null) return 0;
        calculateSumAtLevel(root, 0);
        return sum;
    }

    public static void calculateSumAtLevel(TreeNode head, int level) {
        if (head != null) {
            if (level > maxLevel) {
                sum = 0;
                maxLevel = level;
            }
            if (level == maxLevel)
                sum += head.val;
            calculateSumAtLevel(head.left, level + 1);
            calculateSumAtLevel(head.right, level + 1);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
