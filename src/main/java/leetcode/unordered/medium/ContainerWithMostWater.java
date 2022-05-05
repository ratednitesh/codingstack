package main.java.leetcode.unordered.medium;

/***************************
 * https://leetcode.com/problems/container-with-most-water/
 ****************************/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end) {
            int width = end - start;
            int minHeight = Math.min(height[start], height[end]);
            area = Math.max(area, minHeight * width);
            if (height[start] < height[end])
                start++;
            else if (height[start] > height[end])
                end--;
            else {
                start++;
                end--;
            }
        }
        return area;
    }
}
