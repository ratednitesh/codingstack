package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without 
 * changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 ****************************/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLISDFSWithCache(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    // Optimal Approach : DP + BFS O(NLogN)
    public static int lengthOfLIS(int[] nums) {
        // logic: create a DP array of size nums.length and keep adding the numbers to it if x is increasing
        // when doing so update the size var.. notice the the dp array from 0 to size will be sorted.
        // if x is smaller than dp[i] update dp[i] with the new x.
        /*
        tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6
We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.

Each time we only do one of the two:

(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]
Doing so will maintain the tails invariant. The the final answer is just the size.
         */
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

    //  Brute Force | DFS| BackTrack | O(2^N) - time limit exceeded

    public static int lengthOfLISDFS(int[] nums) {
        int longestCount = 0;
        for (int i = 0; i < nums.length; i++) {
            longestCount = Math.max(longestCount, dfs(nums, nums[i], i, 1));
        }
        return longestCount;
    }


    private static int dfs(int[] nums, int currValue, int currIndex, int currLength) {
        int oldCurrLength = currLength;
        for (int i = currIndex + 1; i < nums.length; i++) {
            if (nums[i] > currValue)
                currLength = Math.max(currLength, dfs(nums, nums[i], i, oldCurrLength + 1));
        }
        return currLength;
    }

    // TODO: Brute Force | DFS| BackTrack with cache | O(N^2)
    //https://www.youtube.com/watch?v=cjWnW0hdF1Y
    public static int lengthOfLISDFSWithCache(int[] nums) {
        int[] dp = new int[nums.length];
        int longestCount = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            longestCount = Math.max(longestCount, dfsWithCache(nums, nums[i], i, 1, dp));
        }
        return longestCount;
    }


    private static int dfsWithCache(int[] nums, int currValue, int currIndex, int currLength, int[] dp) {
        if (dp[currIndex] != 0)
            return dp[currIndex] + currLength;
        int oldCurrLength = currLength;
        for (int i = currIndex + 1; i < nums.length; i++) {
            if (nums[i] > currValue)
                currLength = Math.max(currLength, dfsWithCache(nums, nums[i], i, oldCurrLength, dp));
        }
        dp[currIndex] = currLength;
        return currLength;
    }

    // another approach dp
    public static int lengthOfLISDP(int[] nums) {
        int[] dp = new int[nums.length]; // storing maxLength starting from each index
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
