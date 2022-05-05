package main.java.leetcode.datatype.string;

import java.util.Stack;

/***************************
 * https://leetcode.com/problems/simplify-path/
 ****************************/
public class SimplifyUnixPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../../home/./../...//foo/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPathUsingStacks("/../../home/./../...//foo/"));
        System.out.println(simplifyPathUsingStacks("/home//foo/"));
    }

    public static String simplifyPath(String path) {
        String[] token = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (String s : token) {
            if (s.equals("..")) {
                if (sb.lastIndexOf("/") == -1)
                    continue;
                sb.delete(sb.lastIndexOf("/"), sb.length());
            } else if ((!s.isEmpty() && !s.equals("."))) {
                sb.append("/").append(s);
            }
        }
        return sb.toString().equals("") ? "/" : sb.toString();
    }

    // Using Stacks
    public static String simplifyPathUsingStacks(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String s : stack) {

            result.append("/").append(s);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
