package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 ****************************/
public class OneSwapToMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] indexes = new int[2];
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (k == 2)
                    return false;
                indexes[k++] = i;
            }

        }
        return k == 0 || (
                s1.charAt(indexes[0]) == s2.charAt(indexes[1])
                        && s1.charAt(indexes[1]) == s2.charAt(indexes[0]));
    }
}
