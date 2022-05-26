package main.java.leetcode.datastructure.matrix;

/***************************
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 ****************************/
public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] arr = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(arr));
    }

    // Approach: Same as DFS, just instead of visited use a cache matrix to capture the max length found for every cell so far
    public static int longestIncreasingPath(int[][] matrix) {
        int longestPath = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1)
            return 1;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(dfs(matrix, cache, m, n, i, j), longestPath);
            }
        }
        return longestPath;
    }

    public static final int[][] gridHelper = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int dfs(int[][] matrix, int[][] cache, int m, int n, int i, int j) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] h : gridHelper) {
            int x = i + h[0], y = j + h[1];
            if (x < 0 || x >= m || y >= n || y < 0 || matrix[x][y] <= matrix[i][j])
                continue;
            max = Math.max(max, 1 + dfs(matrix, cache, m, n, x, y));
        }
        cache[i][j] = max;
        return max;
    }
}
