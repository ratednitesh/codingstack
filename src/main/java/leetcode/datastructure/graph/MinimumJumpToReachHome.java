package main.java.leetcode.datastructure.graph;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/minimum-jumps-to-reach-home/
 ****************************/
public class MinimumJumpToReachHome {
    public static void main(String[] args) {
        System.out.println(minimumJumps(new int[]{128, 178, 147, 165, 63, 11, 150, 20, 158, 144, 136}, 61, 170, 135));
    }


    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        /* max shortest distance possible to travel for reaching home: Max(x, max(forbid)) + b +a */
        int steps = 0, furthest = x + a + b;
        HashSet<AbstractMap.SimpleEntry<Integer, Boolean>> seen = new HashSet<>();// pair of direction and index
        Queue<AbstractMap.SimpleEntry<Integer, Boolean>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<>(0, false));
        for (int pos : forbidden) {
            seen.add(new AbstractMap.SimpleEntry<>(pos, false));
            seen.add(new AbstractMap.SimpleEntry<>(pos, true));
            furthest = Math.max(furthest, pos + a + b);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                AbstractMap.SimpleEntry<Integer, Boolean> p = q.poll();
                boolean dir = p.getValue();
                int pos = p.getKey();
                if (pos == x) {
                    return steps;
                }
                AbstractMap.SimpleEntry<Integer, Boolean> forward = new AbstractMap.SimpleEntry<>(pos + a, true),
                        backward = new AbstractMap.SimpleEntry<>(pos - b, false);
                if (pos + a <= furthest && seen.add(forward)) {
                    q.offer(forward);
                }
                if (dir && pos - b >= 0 && seen.add(backward)) {
                    q.offer(backward);
                }
            }
            steps++;
        }
        return -1;
    }


}
