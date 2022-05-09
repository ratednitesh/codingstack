package main.java.leetcode.datatype.numbers;

import java.util.LinkedList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/fizz-buzz/
 ****************************/
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(16));
    }

    public static List<String> fizzBuzz(int n) {
        int i = 3;
        List<String> l = new LinkedList<>();
        l.add("1");
        if (n == 1) return l;
        l.add("2");
        if (n == 2)
            return l;
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0)
                l.add("FizzBuzz");
            else if (i % 3 == 0)
                l.add("Fizz");
            else if (i % 5 == 0)
                l.add("Buzz");
            else
                l.add(String.valueOf(i));
            i++;
        }
        return l;

    }
}
