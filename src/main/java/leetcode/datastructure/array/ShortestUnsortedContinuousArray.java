package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 ****************************/
public class ShortestUnsortedContinuousArray {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(arr));
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(findUnsortedSubarray(arr2));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int leftMax = nums[0], rightIndex = -1;
        int rightMin = nums[nums.length - 1], leftIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= leftMax)
                leftMax = nums[i];
            else {
                rightIndex = i;
            }

            if (nums[nums.length - 1 - i] <= rightMin)
                rightMin = nums[nums.length - 1 - i];
            else {
                leftIndex = nums.length - 2 - i;
            }
        }
        return Math.max(rightIndex - leftIndex, 0);
    }
}
