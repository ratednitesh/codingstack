package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/minimum-distance-to-the-target-element/
 ****************************/
public class MinimumDistanceToTargetElement {
    public static void main(String[] args) {
        System.out.println(getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3));
    }

    public static int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int abs = Math.abs(start - i);
                if (abs == 0)
                    return 0;
                if (abs < min)
                    min = abs;
            }
        }
        return min;
    }
}
