package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 ****************************/
public class AscendingNumbers {
    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

    public static boolean areNumbersAscending(String s) {
        int prev = -1;
        for (String s1 : s.split(" ")) {     //Separate words from String
            if (s1.charAt(0) >= '0' && s1.charAt(0) <= '9') {     // True means word is a number
                int curr = Integer.parseInt(s1);     // parsing to int from String
                if (prev < curr) prev = curr;     // update prev with curr for next comparision
                else
                    return false;
            }
        }
        return true;
    }
}
