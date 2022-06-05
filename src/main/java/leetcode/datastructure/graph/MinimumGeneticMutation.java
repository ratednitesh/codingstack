package main.java.leetcode.datastructure.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/minimum-genetic-mutation/
 ****************************/
public class MinimumGeneticMutation {
    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }

    public static int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        HashSet<String> bankData = new HashSet<>(Arrays.asList(bank));
        if (!bankData.contains(end))
            return -1;
        HashSet<String> visitedMutations = new HashSet<>();
        char[] legalGenes = {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visitedMutations.add(start);
        int mutations = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String curr = q.poll();
                if (curr.equals(end))
                    return mutations;
                char[] currArray = curr.toCharArray();
                for (int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : legalGenes) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (!visitedMutations.contains(next) && bankData.contains(next)) {
                            visitedMutations.add(next);
                            q.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            mutations++;
        }
        return -1;
    }
}
