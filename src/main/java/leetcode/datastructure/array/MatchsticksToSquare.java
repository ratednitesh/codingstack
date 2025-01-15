package main.java.leetcode.datastructure.array;

import java.util.Arrays;
import java.util.Collections;

/***************************
 * https://leetcode.com/problems/matchsticks-to-square/
 ****************************/
public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4)
            return false;
        int perimeter = 0;
        for (int m : matchsticks)
            perimeter += m;
        if (perimeter % 4 != 0)
            return false;
        int side = perimeter / 4;
        Arrays.sort(matchsticks);
        return makeSquare(matchsticks, matchsticks.length - 1, 0, 0, 0, 0, side);
    }

    private boolean makeSquare(int[] matchsticks, int index, int top, int bottom, int left, int right, int side) {
        if (top == side && bottom == side && right == side && left == side)
            return true;
        if (top > side || bottom > side || left > side || right > side)
            return false;
        int val = matchsticks[index];
        if (makeSquare(matchsticks, index - 1, top + val, bottom, left, right, side))
            return true;
        if (makeSquare(matchsticks, index - 1, top, bottom + val, left, right, side))
            return true;
        if (makeSquare(matchsticks, index - 1, top, bottom, left + val, right, side))
            return true;
        if (makeSquare(matchsticks, index - 1, top, bottom, left, right + val, side))
            return true;
        return false;
    }

    //optimized version
    // TODO: fully understand below solution
    public boolean makesquare2(int[] matchsticks) {
        if (matchsticks.length < 4)
            return false;
        int perimeter = 0;
        for (int m : matchsticks)
            perimeter += m;
        if (perimeter % 4 != 0)
            return false;
        int side = perimeter / 4;
        Arrays.sort(matchsticks);
        return makeSquare(matchsticks, matchsticks.length - 1, new int[4], side);
    }

    private boolean makeSquare(int[] matchsticks, int index, int[] sum, int side) {
        if (index < 0)
            return true;
        for (int i = 0; i < 4; i++) {
            if (sum[i] + matchsticks[index] > side || (i > 0 && sum[i] == sum[i - 1]))
                continue;
            sum[i] += matchsticks[index];
            if (makeSquare(matchsticks, index - 1, sum, side))
                return true;
            sum[i] -= matchsticks[index];
        }
        return false;
    }
}
