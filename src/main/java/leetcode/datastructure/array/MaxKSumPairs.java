package main.java.leetcode.datastructure.array;

import java.util.Arrays;
import java.util.HashMap;

/***************************
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 ****************************/
public class MaxKSumPairs {
    public static void main(String[] args) {
        int[] arr = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
        System.out.println(maxOperationsTP(arr, 2));
    }

    // Two Pointer Approach
    public static int maxOperationsTP(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int max = 0;
        Arrays.sort(nums);
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == k) {
                max++;
                start++;
                end--;
            } else if (sum < k)
                start++;
            else
                end--;
        }
        return max;
    }

    // HashMap
    public static int maxOperationsHM(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (hm.containsKey(k - num) && hm.get(k - num) > 0) {
                hm.put(k - num, hm.get(k - num) - 1);
                max++;
            } else
                hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return max;
    }

    // brute force
    public static int maxOperations(int[] nums, int k) {
        int max = 0;
        if (nums.length < 2)
            return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == -1)
                continue;
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != -1 && nums[j] == (k - first)) {
                    nums[i] = -1;
                    nums[j] = -1;
                    max++;
                    break;
                }
            }
        }
        return max;
    }
}
