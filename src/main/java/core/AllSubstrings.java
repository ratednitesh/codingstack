package main.java.core;
/***************************
 *
 ****************************/

import java.util.HashSet;

public class AllSubstrings {
    public static void main(String[] args) {
        allUniqueSubstrings("abcabcabd");
    }

    public static void allUniqueSubstrings(String s) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                System.out.println(sb);
                hs.add(sb.toString());
            }
        }
        for (String st : hs) {
            System.out.println(st);
        }
    }
}
