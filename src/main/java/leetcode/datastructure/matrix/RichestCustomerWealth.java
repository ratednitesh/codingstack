package main.java.leetcode.datastructure.matrix;

/***************************
 * https://leetcode.com/problems/richest-customer-wealth/
 ****************************/
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                {3, 2, 2}};
        System.out.println(maximumWealth(arr));
    }

    public static int maximumWealth(int[][] accounts) {
        int customerIndex = 0;
        int max = 0;
        while (customerIndex < accounts.length) {
            int bankIndex = 0;
            int sum = 0;
            while (bankIndex < accounts[0].length) {
                sum += accounts[customerIndex][bankIndex];
                bankIndex++;
            }
            if (sum > max)
                max = sum;
            customerIndex++;
        }
        return max;
    }
}
