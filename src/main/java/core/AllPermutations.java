package main.java.core;

public class AllPermutations {
    public static void main(String[] args) {
        permutations("abc");
    }

    public static void permutations(String s) {
        int start = 0;
        int end = s.length() - 1;
        perm(s, start, end);
    }

    public static void perm(String s, int start, int end) {
        if (start == end) {
            System.out.println(s);
        }
        for (int i = start; i <= end; i++) {
            s = swap(s, start, i);
            perm(s, start + 1, end);
            s = swap(s, start, i);

        }
    }

    private static String swap(String s, int start, int end) {
        char[] chars = s.toCharArray();
        char temp = s.charAt(start);
        chars[start] = s.charAt(end);
        chars[end] = temp;
        return String.valueOf(chars);
    }
}
