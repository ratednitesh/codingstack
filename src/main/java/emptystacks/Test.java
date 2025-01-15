package main.java.emptystacks;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        System.out.println(minimumMoves(Arrays.asList(2468), Arrays.asList(8642)));
    }

    public static int minimumMoves(List<Integer> arr1, List<Integer> arr2) {
        int totalMoves = 0;
        for (int i = 0; i < arr1.size(); i++) {
            totalMoves += movesToCompareElements(arr1.get(i), arr2.get(i));
        }
        return totalMoves;
    }

    private static int movesToCompareElements(int i, int j) {
        int moves = 0;
        while (i > 0) {
            int rem1 = i % 10;
            int rem2 = j % 10;
            moves += Math.abs(rem1 - rem2);
            i = i / 10;
            j = j / 10;
        }
        return moves;
    }
}
