package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/jump-game-iii/
 ****************************/
public class JumpGame3 {
    public boolean canReach(int[] A, int i) {
        return i >= 0 && i < A.length && A[i] >= 0 && ((A[i] = -A[i]) == 0 || canReach(A, i + A[i]) || canReach(A, i - A[i]));

        // Explanation:
        /*
            The first two conditions are edge cases to return false if i crosses the boundary of the array.
            The final and condition covers:
                - If 0 found return true.
                - If not, recursively check in i +/- A[i]
                - now to mark already visited nodes,  make value of A[i] negative. Can be done during 0 compare.
            The third And condition is to check for visited nodes.
         */
    }
}
