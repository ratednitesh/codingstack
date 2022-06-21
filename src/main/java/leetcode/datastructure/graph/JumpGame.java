package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/jump-game/
 ****************************/
public class JumpGame {
//    The basic idea is this: at each step, we keep track of the furthest reachable index. The nature of the problem (eg. maximal jumps where you can hit a range of targets instead of singular jumps where you can only hit one target) is that for an index to be reachable, each of the previous indices have to be reachable.
//
//            Hence, it suffices that we iterate over each index, and If we ever encounter an index that is not reachable, we abort and return false. By the end, we will have iterated to the last index. If the loop finishes, then the last index is reachable.

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    // Optimal
    public boolean canJumpEnhanced(int[] nums) {
        int reachable = 0, len = nums.length;
        for (int i = 0; i < len && i <= reachable; i++) {
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= len - 1) return true;   // terminate loop early to speed up
        }
        return false;

    }

    //dfs solution - takes longer time
    boolean[] visited;
    boolean status = false;

    public boolean canJumpDFS(int[] nums) {
        visited = new boolean[nums.length];
        return dfs(nums, 0);
    }


    public boolean dfs(int[] nums, int start) {
        if (start >= nums.length - 1)
            return true;
        if (nums[start] == 0)
            return false;

        visited[start] = true;

        for (int i = start + 1; i <= start + nums[start]; i++) {
            if (!visited[i]) {
                if (dfs(nums, i))
                    return true;
            }
        }
        return false;
    }

    // DP Solution // TODO: Refine this solution
    public boolean canJumpDP(int[] nums) {
        int n = nums.length;
        int[] mem = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i > mem[i]) {
                return false;
            } else {
                mem[i + 1] = Math.max(mem[i], nums[i] + i);
                if (mem[i] > n)
                    return true;
            }
        }
        return true;
    }
}
