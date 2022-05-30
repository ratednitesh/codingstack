package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 ****************************/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, n = nums.length, high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[high] < nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        int rot = low;
        low = 0;
        high = n - 1;
        System.out.println(rot);
        while (low <= high) {
            int mid = (low + high) / 2;
            int realMid = (mid + rot) % n;
            if (nums[realMid] == target)
                return realMid;
            if (nums[realMid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Optimized Solution
    public int searchOpt(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] <= nums[mid]) {
                if (nums[mid] > target && nums[low] <= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] < target && nums[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
