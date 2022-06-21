package main.java.leetcode.operations.dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***************************
 * https://leetcode.com/problems/word-break/
 ****************************/
public class WordBreak {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), new HashSet<>());
    }

    public boolean wordBreak(String s, Set<String> wordDict, Set<String> notDict) {
        int n = s.length();
        if (s.length() == 0)
            return true;
        if (wordDict.contains(s))
            return true;
        else if (notDict.contains(s))
            return false;
        for (int i = 1; i <= n; i++) {
            if (wordDict.contains(s.substring(0, i))) {
                String sub = s.substring(i, n);
                if (wordBreak(sub, wordDict, notDict)) {
                    wordDict.add(sub);
                    return true;
                } else
                    notDict.add(sub);
            }
        }
        return false;
    }
    // TODO: DP bottom up approach and top down approach without HashSet
}
