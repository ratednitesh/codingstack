package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 ****************************/
public class SumOfAllOddLengthSubArray {
    public static void main(String[] args) {
        test();
    }

    /**
     * 1 4 2 5 3
     * - - - - -	(1-odd length)
     * -----		(3-odd length)
     * ------	(3-odd length)
     * ------	(3-odd length)
     * ----------	(5-odd length)
     * 3 4 5 4 3   (number of multiples by counting number of odd lengths column wise) -> To get this, the formula is ((n-i) * (i+1) + 1)/2
     * <p>
     * Pattern:
     * 1
     * 1 1
     * 2 2 2
     * 2 3 3 2
     * 3 4 5 4 3
     * From this pattern it's obvious that each column increments in a pattern which we can translate to a mathematical formula.
     * The first column goes up by 0.5 for every additional element. The second column goes up by 1 for every additional element.
     * The third column goes up by 1.5 for every additional element, and so on. All of these are rounded up, so a 1.5 rounds up to 2.
     * The first part of the formula then is to determine the scaling factor based on the index value, (0.5*(n+1)).
     * The second part of the formula is to multiply by the length of the array minus our index value to set the start of the series.
     */
    public static void test() {
        for (int n = 1; n < 11; n++) {
            for (int i = 0; i < n; i++)
                System.out.print((((i + 1) * (n - i) + 1) / 2) + " ");
            System.out.println();
        }
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, n = arr.length;
        for (int i = 0; i < n; i++)
            sum += arr[i] * (((i + 1) * (n - i) + 1) / 2);
        return sum;
    }

}
