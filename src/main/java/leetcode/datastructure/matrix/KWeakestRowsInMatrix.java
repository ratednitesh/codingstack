package main.java.leetcode.datastructure.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 ****************************/
public class KWeakestRowsInMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1},
        };
        System.out.println(Arrays.toString(kWeakestRows(arr, 5)));
    }

    // Priority Queue + Binary Search
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        // make a max heap such that the size of heap is at max k
        // the top element will go to the end of result array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[]{indexOfFirstZero(mat[i]), i});
            if (pq.size() > k)
                pq.poll();
        }
        while (k > 0) {
            result[--k] = pq.poll()[1];
        }
        return result;
    }

    private static int indexOfFirstZero(int[] row) {
        int high = row.length;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // Brute Force Approach
    public static int[] kWeakestRowsBF(int[][] mat, int k) {
        int[] result = new int[k];
        int l = 0;
        int m = 0;
        HashSet<Integer> hs = new HashSet<>();
        while (m < mat[0].length) {
            int n = 0;
            while (n < mat.length) {
                if (!hs.contains(n) && mat[n][m] == 0) {
                    hs.add(n);
                    result[l] = n;
                    l++;
                    if (l == k)
                        return result;
                }
                n++;
            }
            m++;
        }
        int i = 0;
        while (l < k) {
            if (!hs.contains(i)) {
                result[l] = i;
                l++;
            }
            i++;
        }
        return result;
    }
}
