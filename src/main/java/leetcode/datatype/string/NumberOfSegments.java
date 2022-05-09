package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 ****************************/
public class NumberOfSegments {
    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }

    public static int countSegments(String s) {
        String[] tokens = s.split(" ");
        int ans = 0;
        for (String t : tokens) {
            if (t.length() > 0) ans++;
        }
        return ans;
    }
}
