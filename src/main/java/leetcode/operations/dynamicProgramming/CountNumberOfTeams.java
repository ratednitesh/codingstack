package main.java.leetcode.operations.dynamicProgramming;

import java.util.TreeSet;

/***************************
 * https://leetcode.com/problems/count-number-of-teams/
 ****************************/
public class CountNumberOfTeams {
    public static void main(String[] args) {

    }

    // recursive solution - TLE
    int totalCount = 0;

    public int numTeams(int[] rating) {
        for (int i = 0; i < rating.length; i++) {
            count(rating, i, 1, true);
            count(rating, i, 1, false);
        }
        return totalCount;
    }

    private void count(int[] rating, int index, int position, boolean isAscending) {
        if (position == 3)
            totalCount++;
        else {
            for (int i = index + 1; i < rating.length; i++) {
                if (rating[i] > rating[index] && isAscending) {
                    count(rating, i, position + 1, true);
                }
                if (rating[i] < rating[index] && !isAscending) {
                    count(rating, i, position + 1, false);
                }
            }
        }
    }

    // A better approach
    public int numTeamsOBetter(int[] rating) {
        int index = 1, totalTeams = 0;
        while (index < rating.length - 1) {
            int beforeLowTeams = 0, beforeHighTeams = 0, afterLowTeams = 0, afterHighTeams = 0;
            for (int i = 0; i < rating.length; i++) {
                if (rating[i] < rating[index]) {
                    if (i < index)
                        beforeLowTeams++;
                    else
                        afterLowTeams++;
                }
                if (rating[i] > rating[index]) {
                    if (i < index)
                        beforeHighTeams++;
                    else
                        afterHighTeams++;
                }
            }
            totalTeams += (beforeHighTeams * afterLowTeams) + (beforeLowTeams * afterHighTeams);
            index++;
        }
        return totalTeams;
    }

    // Refined way of above solution
    public int numTeamsRefined(int[] rating) {
        int n = rating.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) l++;
            }

            for (int k = i + 1; k < n; k++) {
                if (rating[i] < rating[k]) r++;
            }

            ans += (l * r) + (i - l) * (n - i - r - 1);
        }

        return ans;
    }

    // TODO : understand below DP solution
    public int numTeamsDP(int[] rating) {
        int[] inc = new int[rating.length];
        int[] dec = new int[rating.length];
        int ans = 0;

        for (int i = 0; i < rating.length; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    inc[i]++;
                    ans += inc[j];
                } else {
                    dec[i]++;
                    ans += dec[j];
                }
            }
        }

        return ans;
    }

    // TreeSet solution
    public int numTeamsTree(int[] rating) {
        TreeSet<Integer> afterTree = new TreeSet<>();
        TreeSet<Integer> beforeTree = new TreeSet<>();
        int totalCount = 0;
        for (int r : rating)
            afterTree.add(r);
        for (int i = 0; i < rating.length; i++) {
            afterTree.remove(rating[i]);
            beforeTree.add(rating[i]);
            // rating[i]< rating[j]< rating[k] case
            int leftSmaller = beforeTree.subSet(Integer.MIN_VALUE, rating[i]).size();
            int rightBigger = afterTree.subSet(rating[i], Integer.MAX_VALUE).size();
            totalCount += leftSmaller * rightBigger;
            // reverse
            int leftBigger = beforeTree.subSet(rating[i] + 1, Integer.MAX_VALUE).size();
            int rightSmaller = afterTree.subSet(Integer.MIN_VALUE, rating[i]).size();
            totalCount += leftBigger * rightSmaller;
        }
        return totalCount;
    }
}
