package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
 ****************************/
public class MaximumDistanceBetweenPairOfValues {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
    }

    public static int maxDistance(int[] n1, int[] n2) {
        int i = 0, j = 0, res = 0;
        while (i < n1.length && j < n2.length)
            if (n1[i] > n2[j])
                ++i;
            else
                res = Math.max(res, j++ - i);
        return res;
    }

    public static int maxDistanceBS(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int l = i, r = nums2.length - 1;

            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums1[i] > nums2[m]) {
                    r = m - 1; //as sorted in decreasing order
                } else {
                    l = m + 1;
                }
            }
            if (r < 0) {
                continue;
            }
            max = Math.max(max, r - i);
        }
        return max;
    }
}
