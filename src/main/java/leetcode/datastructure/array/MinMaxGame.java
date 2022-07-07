package main.java.leetcode.datastructure.array;
/***************************
* https://leetcode.com/problems/min-max-game/
****************************/
public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int n =nums.length;

        while (n > 1) {
            n /= 2;
            int i = 0;
            int[] temp = new int[n];
            while (i < n) {
                if (i % 2 == 0)
                    temp[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                else
                    temp[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                i++;
            }
            nums=temp;
        }
        return nums[0];
    }
}
