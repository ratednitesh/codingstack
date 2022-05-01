package main.java.algo.string;

/***************************
 https://leetcode.com/problems/backspace-string-compare/
 ****************************/
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }

    public static boolean backspaceCompare(String s, String t) {
        return performBsp(s).equals(performBsp(t));
    }

    public static String performBsp(String s) {
        StringBuilder new_s = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                count++;
            } else {
                if (count > 0)
                    count--;
                else
                    new_s.append(s.charAt(i));
            }
        }
        return new_s.toString();
    }
    // Todo: Two pointer approach
}
