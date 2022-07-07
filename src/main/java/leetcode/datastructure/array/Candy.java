package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
*
****************************/
public class Candy {
    public int candy(int[] ratings){
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1); // initialize result array with 1 as each child must have at least one candy
        // iterate from beginning
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) { // if current child has more rating than last one
                res[i] = res[i - 1] + 1; // he should have one more candy than last one.
            }
        }
        // iterate from last
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) { // if current child 'i-1' has more rating than next one 'i'
                res[i - 1] = Math.max(res[i] + 1, res[i - 1]); // he should have more candy than next one, if he do not have more candies already
            }
        }

        int sum = 0;
        for (int r : res) sum += r; // sum all candies

        return sum;
    }

    // todo: understand below solution using AP
    public int candyOpt(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (countDown > 0) {
                    total += countDown*(countDown+1)/2; // arithmetic progression
                    if (countDown >= prev) total += countDown - prev + 1;
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i-1] ? 1 : prev+1;
                total += prev;
            } else countDown++;
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown*(countDown+1)/2;
            if (countDown >= prev) total += countDown - prev + 1;
        }
        return total;
    }
}
