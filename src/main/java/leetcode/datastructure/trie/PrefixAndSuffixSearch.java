package main.java.leetcode.datastructure.trie;

import java.util.HashMap;

/***************************
 * https://leetcode.com/problems/prefix-and-suffix-search/
 ****************************/
public class PrefixAndSuffixSearch {
    HashMap<String, Integer> mp;

    public PrefixAndSuffixSearch(String[] words) {
        mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {

                String prefix = words[i].substring(0, j + 1);

                for (int k = words[i].length() - 1; k > -1; k--) {

                    String suffix = words[i].substring(k);
                    mp.put(prefix + "#" + suffix, i);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {

        return mp.getOrDefault(prefix + "#" + suffix, -1);
    }
    // TODO: Trie solution
    
}
