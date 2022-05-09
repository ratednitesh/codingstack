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
}
