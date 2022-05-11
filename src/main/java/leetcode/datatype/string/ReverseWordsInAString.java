package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/reverse-words-in-a-string/
 ****************************/
public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (tokens[i].length() > 0) {
                sb.append(tokens[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
