package main.java.leetcode.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;

/***************************
* https://leetcode.com/problems/queue-reconstruction-by-height/
****************************/
public class QueueReconstructByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // sort in decreasing order of height -> and increasing order of k value
        Arrays.sort(people, ((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o1[1] - o2[1]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][]);
    }
}
