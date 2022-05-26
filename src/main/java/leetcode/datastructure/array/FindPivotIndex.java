package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/find-pivot-index/
 ****************************/
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int pivot = 0;
        int rightSum = 0;
        for (int n : nums)
            rightSum += n;
        int leftSum = 0, prev = 0;
        for (int num : nums) {
            rightSum = rightSum - num;
            leftSum += prev;
            prev = num;
            if (leftSum == rightSum)
                return pivot;
            pivot++;
        }
        return -1;
    }
}
