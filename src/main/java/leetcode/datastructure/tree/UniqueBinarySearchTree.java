package main.java.leetcode.datastructure.tree;
/***************************
*https://leetcode.com/problems/unique-binary-search-trees/
****************************/
public class UniqueBinarySearchTree {
    public int numTrees(int n){
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
