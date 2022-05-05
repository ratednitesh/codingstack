package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/search-insert-position/
 ****************************/
public class SearchOrInsertSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert(arr, 5));
        System.out.println(searchInsert(arr, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index = (start + end) / 2;
        while (start <= end) {
            if (nums[index] == target)
                return index;
            if (nums[index] < target) {
                start = index + 1;
            } else if (nums[index] > target) {
                end = index - 1;
            }
            index = (start + end) / 2;
        }
        return start;
    }
}
