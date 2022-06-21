package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 ****************************/
public class AlienDictionary {
    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        if (n == 1)
            return true;
        int[] num = new int[26];
        int i = 0;
        for (char o : order.toCharArray()) {
            num[o - 'a'] = i;
            i++;
        }
        for (i = 1; i < n; i++) {
            if (!compare(words[i - 1].toCharArray(), words[i].toCharArray(), num))
                return false;
        }
        return true;
    }

    private boolean compare(char[] w1, char[] w2, int[] num) {
        int n = w1.length, m = w2.length;
        for (int i = 0; i < n && i < m; i++) {
            if (w1[i] != w2[i])
                return num[w1[i] - 'a'] < num[w2[i] - 'a'];
        }
        return m >= n;
    }
}
