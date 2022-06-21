package main.java.leetcode.operations.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/***************************
 * https://leetcode.com/problems/longest-string-chain/
 ****************************/
public class LongestStringChain {
    public static void main(String[] args) {
        int len = new LongestStringChain().longestStrChainDPMemo(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"});
        System.out.println(len);
    }

    // using BackTracking
    public int longestStrChain(String[] words) {
        int maxLen = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            maxLen = Math.max(maxLen, backTrack(words, i, words[i], 1));
        }
        return maxLen;
    }

    private int backTrack(String[] words, int index, String word, int len) {

        int oldLen = len;
        for (int i = index + 1; i < words.length; i++) {
            for (int k = 0; k < words[i].length(); k++) {
                String newWord = words[i].substring(0, k) + words[i].substring(k + 1);
//                System.out.println(word + " " + newWord);
                if (word.equals(newWord)) {
                    len = Math.max(len, oldLen + backTrack(words, i, words[i], oldLen));
                    break;
                }
            }
        }
        return len;
    }

    // sort + dp
    public int longestStrChainDPMemo(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        HashMap<String, Integer> dp = new HashMap<>();
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            int maxLen = 0;
            for (int k = 0; k < words[i].length(); k++) {
                String newWord = words[i].substring(0, k) + words[i].substring(k + 1);
                maxLen = Math.max(maxLen, dp.getOrDefault(newWord, 0) + 1);
            }
            dp.put(words[i], maxLen);
            result = Math.max(result, maxLen);
        }
        return result;
    }
}
