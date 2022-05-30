package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 ****************************/
public class NumberOfStepsToReduceToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps(int num) {
        int i = 0;
        while (num != 0) {
            if (num % 2 == 0)
                num /= 2;
            else
                num--;
            i++;
        }
        return i;
    }

    // Optimal
    public static int numberOfStepsBW(int num) {
        if (num == 0) return 0;
        int result = 0;

        while (num != 0) {
            // In order to count steps when right shifting one digit
            // For odd: we will subtract and divide by 2, which takes 2 steps
            // For even: we just divide by 2, which takes 1 step
            result += ((num & 1) == 0 ? 1 : 2);
            num >>= 1;
        }
        // We subtract 1 from result because when we the get to the most significant 1,
        // we only need to subtract it and we no longer need to divide by 2, so
        // only 1 step needed instead of the 2 that we counted when using the above while loop
        return result - 1;
    }
}
