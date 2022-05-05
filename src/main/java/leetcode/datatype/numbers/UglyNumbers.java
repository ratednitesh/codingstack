package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/ugly-number/
 ****************************/
public class UglyNumbers {
    public static void main(String[] args) {
        System.out.println(isUgly(14));
        System.out.println(isUgly(30));
    }

    public static boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }

    public static boolean isUglyOther(int n) {
        while (n != 0) {
            boolean flag = false;
            if (n % 2 == 0) {
                n /= 2;
                flag = true;
            }
            if (n % 3 == 0) {
                n /= 3;
                flag = true;
            }
            if (n % 5 == 0) {
                n /= 5;
                flag = true;
            }
            if (!flag)
                return false;
        }
        return true;
    }
}
