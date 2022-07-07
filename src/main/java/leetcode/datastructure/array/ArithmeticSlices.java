package main.java.leetcode.datastructure.array;
/***************************
* https://leetcode.com/problems/arithmetic-slices/
****************************/
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;
        int subSets = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            if (nums[i + 2] - nums[i + 1] == diff)
                subSets += extendAP(nums, diff, i + 3, 1);
        }
        return subSets;
    }

    private int extendAP(int[] nums, int diff, int index, int count) {
        while (index < nums.length && nums[index] - nums[index - 1] == diff) {
            count++;
            index++;
        }
        return count;
    }
}
