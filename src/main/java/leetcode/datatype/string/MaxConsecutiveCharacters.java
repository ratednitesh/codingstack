package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/consecutive-characters/
 ****************************/
public class MaxConsecutiveCharacters {
    public static void main(String[] args) {
        System.out.println(maxPower("aa"));
    }

    public static int maxPowerEnhanced(String s) {
        if (s.length() == 1) return 1;
        int ans = 1;
        for (int i = 1, cnt = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (++cnt > ans) {
                    ans = cnt;
                }
            } else {
                cnt = 1;
            }
        }
        return ans;

    }

    public static int maxPower(String s) {
        if (s.length() == 1) return 1;
        int i = 1;
        int max = 1;
        while (i < s.length()) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                i++;
                continue;
            }
            int count = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
                i++;
            }
            if (max < count + 1) {
                max = count + 1;
            }
        }
        return max;
    }
}
