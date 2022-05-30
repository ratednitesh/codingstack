package main.java.leetcode.datastructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/keys-and-rooms/
 ****************************/
public class KeysAndRooms {
    // dfs - optimal
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> list = new HashSet<>();
        list.add(0);
        return dfs(rooms, 0, list);
    }

    private static boolean dfs(List<List<Integer>> rooms, int room, HashSet<Integer> list) {
        if (list.size() == rooms.size())
            return true;
        for (int r : rooms.get(room)) {
            if (list.contains(r)) continue;
            list.add(r);
            if (dfs(rooms, r, list))
                return true;
        }
        return false;
    }

    // bfs
    public static boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> list = new HashSet<>();
        int n = rooms.size();
        list.add(0);
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int room = q.poll();
                for (int r : rooms.get(room)) {
                    if (!list.contains(room)) {
                        q.offer(room);
                        list.add(room);
                        if (list.size() == n)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}
