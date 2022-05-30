package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/find-peak-element/
 ****************************/
public class FindPeakElements {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 1, 1, 3, 5, 6, 4}));
    }

    public static int findPeakElement(int[] num) {
        for (int i = 1; i < num.length; i++) {
            if (num[i] < num[i - 1]) {
                return i - 1;
            }
        }
        return num.length - 1;
    }

    /*
    Binary Search
    Case 1 : mid lies on the right of our result peak ( Observation : Our peak element search space is leftside )
    Case 2 : mid is equal to the peak element ( Observation : mid element is greater than its neighbors )
    Case 3 : mid lies on the left. ( Observation : Our peak element search space is rightside )
     */
    public int findPeakElementBS(int[] nums) {
        if (nums.length == 1) return 0; // single element

        int n = nums.length;

        // check if 0th/n-1th index is the peak element
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        // search in the remaining array
        int start = 1;
        int end = n - 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] < nums[mid - 1]) end = mid - 1;
            else if (nums[mid] < nums[mid + 1]) start = mid + 1;
        }
        return -1; // dummy return statement
    }
}
