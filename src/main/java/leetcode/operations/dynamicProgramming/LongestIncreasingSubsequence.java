package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without 
 * changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 ****************************/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLISBF(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    // Optimal Approach : DP + BFS O(NLogN)
    public static int lengthOfLIS(int[] nums) {
        // logic: create a DP array of size nums.length and keep adding the numbers to it if x is increasing
        // when doing so update the size var.. notice the the dp array from 0 to size will be sorted.
        // if x is smaller than dp[i] update dp[i] with the new x.
        int[] dp = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int start = 0, end = size;
            while (start != end) {
                int mid = start + (end - start) / 2;
                if (dp[mid] > x)
                    end = mid;
                else
                    start = mid + 1;
            }
            dp[start] = x;
            if (start == size) size++;
        }
        return size;
    }

    // TODO: Brute Force | DFS| BackTrack | O(2^N)

    public static int lengthOfLISBF(int[] nums) {
        return 0;
    }

    // TODO: Brute Force | DFS| BackTrack with cache | O(N^2)
    //https://www.youtube.com/watch?v=cjWnW0hdF1Y
    public static int lengthOfLISBFCache(int[] nums) {
        return 0;
    }
}
