package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 ****************************/
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {

    }

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, n = cardPoints.length;
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        sum = leftSum;

        for (int i = 0; i < k; i++) {
            rightSum += cardPoints[n - 1 - i];
            leftSum -= cardPoints[k - 1 - i];
            sum = Math.max(sum, leftSum + rightSum);
        }
        return sum;
    }
}
