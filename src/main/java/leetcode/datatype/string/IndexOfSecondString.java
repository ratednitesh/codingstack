package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/implement-strstr/
 ****************************/
public class IndexOfSecondString {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hlell", "ll"));
        System.out.println(strStr("hlell", "llo"));
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        int i = 0;
        while (i <= haystack.length() - needle.length()) {
            int j = 0;
            while (j < needle.length()) {
                if (needle.charAt(j) == haystack.charAt(i + j))
                    j++;
                else
                    break;
                if (j == needle.length())
                    return i;
            }
            i++;
        }
        return -1;
    }

    // Approach 2:
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
