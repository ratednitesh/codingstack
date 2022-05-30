package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 ****************************/
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[high] < nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}
