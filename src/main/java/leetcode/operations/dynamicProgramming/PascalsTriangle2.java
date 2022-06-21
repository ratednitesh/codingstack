package main.java.leetcode.operations.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/pascals-triangle-ii/
 ****************************/
public class PascalsTriangle2 {
    public static void main(String[] args) {
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        if (rowIndex == 0)
            return last;
        last.add(1);
        if (rowIndex == 1)
            return last;
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                int left = last.get(j - 1);
                int right = last.get(j);
                curr.add(left + right);
            }

            curr.add(1);
            last = curr;
        }
        return last;
    }
}
