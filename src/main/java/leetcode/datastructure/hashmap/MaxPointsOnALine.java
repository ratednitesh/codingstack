package main.java.leetcode.datastructure.hashmap;

import java.util.HashMap;

/***************************
 * https://leetcode.com/problems/max-points-on-a-line/
 ****************************/
public class MaxPointsOnALine {
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> hm = new HashMap<>();
            int sameP = 0;
            int sameX = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {

                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        sameP++;
                    } else if (points[i][0] == points[j][0]) {
                        sameX++;
                        continue;
                    }
                    double k = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                    if (hm.containsKey(k)) {
                        hm.put(k, hm.get(k) + 1);
                    } else {
                        hm.put(k, 2);
                    }


                    result = Math.max(result, hm.get(k) + sameP);
                }
            }
            result = Math.max(result, sameX);
        }
        return result;
    }
}
