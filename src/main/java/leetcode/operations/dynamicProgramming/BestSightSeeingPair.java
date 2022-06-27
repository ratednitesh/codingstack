package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/best-sightseeing-pair/
 ****************************/
public class BestSightSeeingPair {
    /*
    We need to change the formula of question:
    values[i] + values[j] + i - j -> (values[i] + i) + (values[j] - j), i < j
    Let's make maxLeft stand for max value of (values[i] + i), so
    Initial: maxLeft = values[0] + 0
    Loop: max = max(maxLeft + values[j] - j, max), maxLeft = Max(maxleft, values[j] + j)
     */
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int maxLeft = values[0];
        for (int j = 1; j < values.length; j++) {
            max = Math.max(max, maxLeft + values[j] - j);
            maxLeft = Math.max(maxLeft, values[j] + j);
        }
        return max;
    }

    // ideal approach
    /*
     *Count the current best score in all previous sightseeing spot.
     * Note that, as we go further, the score of previous spot decrement.
     * cur will record the best score that we have met.
     * We iterate each value a in the array A,
     * update res by max(res, cur + a)
     * Also we can update cur by max(cur, a).
     * Note that when we move forward,
     * all sightseeing spot we have seen will be 1 distance further.
     * So for the next sightseeing spot cur = Math.max(cur, a) - 1
     */
    public int maxScoreSightseeingPairOpt(int[] A) {
        int res = 0, cur = 0;
        for (int a : A) {
            res = Math.max(res, cur + a);
            cur = Math.max(cur, a) - 1;
        }
        return res;
    }
}
