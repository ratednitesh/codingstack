package main.java.leetcode.datastructure.graph;

import java.util.*;

/***************************
 * https://leetcode.com/problems/open-the-lock/
 ****************************/
public class OpenTheLock {
    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    public static int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        Queue<String> q = new LinkedList<>();
        HashSet<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains(target) || deads.contains("0000"))
            return -1;
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        q.offer("0000");
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String code = q.poll();
                if (deads.contains(code))
                    continue;
                if (code.equals(target))
                    return depth;
                StringBuilder sb = new StringBuilder(code);
                for (int j = 0; j < 4; j++) {
                    char c = sb.charAt(j);
                    String s1 = sb.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(j + 1);
                    String s2 = sb.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(j + 1);
                    if (!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
//                        System.out.println(s1);
                    }
                    if (!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
//                        System.out.println(s2);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
    // TODO : https://leetcode.com/problems/open-the-lock/discuss/110237/Regular-java-BFS-solution-and-2-end-BFS-solution-with-improvement Two - End BFS Solution
}
