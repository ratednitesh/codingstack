package main.java.leetcode.datastructure.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/***************************
 * https://leetcode.com/problems/word-ladder/
 ****************************/
public class WordLadder {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        HashSet<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            HashSet<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] eachChar = each.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        eachChar[i] = c;
                        String s = new String(eachChar);
                        if (wordSet.contains(s)) {
                            toAdd.add(s);
                            wordSet.remove(s);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0)
                return 0;
            reached = toAdd;
        }
        return distance;
    }
    // TODO: two way BFS solution
}
