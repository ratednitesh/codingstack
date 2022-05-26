package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/number-of-enclaves/
 ****************************/
public class NumberOfEnclaves {
    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
    }

    public static int numEnclaves(int[][] grid) {
        // logic: start from each land cell and travel in all possible directions ; mark the visited cells
        int result = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    edgeFound = false;
                    int temp = dfs(grid, m, n, i, j);
                    if (!edgeFound)
                        result += temp;
                }
            }
        }
        return result;
    }

    static int[][] helperGrid = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    static boolean edgeFound = false;

    private static int dfs(int[][] grid, int m, int n, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0) {
            edgeFound = true;
            return 0;
        } else if (grid[i][j] == 0)
            return 0;
        else {
            int result = 1;
            grid[i][j] = 0;
            for (int[] g : helperGrid) {
                result += dfs(grid, m, n, i + g[0], j + g[1]);
            }
            return result;
        }
    }

    // Approach 2: only find edge ones run dfs on them to update them to zero. Find count of remaining ones for ans
    public int numEnclavesOpt(int[][] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1)
                    dfs(A, i, j);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1)
                    result++;
            }
        }

        return result;
    }

    public void dfs(int a[][], int i, int j) {
        if (i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
            a[i][j] = 0;
            dfs(a, i + 1, j);
            dfs(a, i - 1, j);
            dfs(a, i, j + 1);
            dfs(a, i, j - 1);
        }
    }
}
