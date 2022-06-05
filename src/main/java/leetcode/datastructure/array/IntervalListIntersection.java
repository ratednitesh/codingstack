package main.java.leetcode.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/interval-list-intersections/
 ****************************/
public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        for (int[] first : firstList) {
            int start = first[0];
            int end = first[1];
            for (int[] second : secondList) {
                if (second[0] <= end && second[1] >= start) {
                    int x = Math.max(second[0], start);
                    int y = Math.min(second[1], end);
                    list.add(new int[]{x, y});
                }

            }
        }
        int[][] result = new int[list.size()][2];
        int i = 0;
        for (int[] x : list)
            result[i++] = x;
        return result;
    }

    // Using two pointers
    public int[][] intervalIntersectionTP(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[0][0];
        int i = 0;
        int j = 0;
        int startMax, endMin;
        List<int[]> ans = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            startMax = Math.max(firstList[i][0], secondList[j][0]);
            endMin = Math.min(firstList[i][1], secondList[j][1]);

            //you have end greater than start and you already know that this interval is surrounded with startMin and endMax
            // so this must be the intersection
            if (endMin >= startMax) {
                ans.add(new int[]{startMax, endMin});
            }

            //the interval with min end has been covered completely and have no chance to intersect
            // with any other interval so move that list's pointer
            if (endMin == firstList[i][1]) i++;
            if (endMin == secondList[j][1]) j++;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}