package main.java.algo.bitwise;

/***************************
 https://leetcode.com/problems/total-hamming-distance/
 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
 ****************************/
public class TotalHammingDistance {
    public static void main(String[] args) {
        int[] arr = {4, 14, 4};
        System.out.println(totalHammingDistance(arr));
    }

    public static int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += nums[j] & 1;
                nums[j] >>= 1;
            }
            total += count * (nums.length - count);
        }
        return total;
    }
}
