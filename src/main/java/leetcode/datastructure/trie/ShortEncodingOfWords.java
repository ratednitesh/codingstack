package main.java.leetcode.datastructure.trie;

/***************************
 * https://leetcode.com/problems/short-encoding-of-words/
 ****************************/
public class ShortEncodingOfWords {
    public static void main(String[] args) {
        System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    class TrieNode {
        public TrieNode[] children;
        public int height;

        TrieNode() {
            children = new TrieNode[26];
            height = 0;
        }

    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words)
            insert(root, w);

        dfs(root);
        return sumOfLeafHeight;
    }

    int sumOfLeafHeight = 0;

    private void dfs(TrieNode root) {
        if (root == null)
            return;
        int numOfChildren = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                numOfChildren++;
                dfs(root.children[i]);
            }
        }
        if (numOfChildren == 0) {// leaf
            sumOfLeafHeight += root.height + 1;
        }
    }

    private void insert(TrieNode root, String w) {
        for (int i = w.length() - 1; i >= 0; i--) {
            char c = w.charAt(i);
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            int prevHeight = root.height;
            root = root.children[c - 'a'];
            root.height = prevHeight + 1;
        }
    }
    // TC : O(c) - where c is total no. of chars in words array.
}
