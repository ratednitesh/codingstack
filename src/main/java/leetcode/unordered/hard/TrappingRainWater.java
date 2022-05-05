package main.java.leetcode.unordered.hard;

/***************************
 * https://leetcode.com/problems/trapping-rain-water/
 ****************************/
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapBasic(arr));
        System.out.println(trapTwoPointer(arr));
    }

    // Basic Approach
    public static int trapBasic(int[] height) {
        // for each position find left and right max; trapped water on that position = 
        // min(left max , right max) - height of that position.
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0, rightMax = 0;
            // finding left max
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // find right max
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int water = Math.min(leftMax, rightMax) - height[i];
            trappedWater += Math.max(water, 0);
        }
        return trappedWater;
    }

    // DP Approach
    public static int trap(int[] height) {
        int len = height.length;
        if (len <= 2)
            return 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];

        for (int i = 1, j = len - 2; i < len; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int totalWater = 0;
        for (int i = 1; i < len - 1; i++) {
            int water = Math.min(leftMax[i - 1], rightMax[i + 1]) - height[i];
            totalWater += Math.max(water, 0);
        }
        return totalWater;
    }

    // Best Solution
    public static int trapTwoPointer(int[] height) {
        int trappedWater = 0;
        int start = 0;
        int end = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (start < end) {
            if (height[start] > leftMax)
                leftMax = height[start];
            if (height[end] > rightMax)
                rightMax = height[end];
            if (leftMax < rightMax) {
                trappedWater += leftMax - height[start];
                start++;
            } else {
                trappedWater += rightMax - height[end];
                end--;
            }
        }
        return trappedWater;
    }
}
