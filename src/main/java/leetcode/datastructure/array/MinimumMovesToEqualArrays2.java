package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
* https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
****************************/
public class MinimumMovesToEqualArrays2 {
    public int minMoves2(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length -1;
        while(left<right){
            result += nums[right--] - nums[left++];
        }
        return result;
    }
}
