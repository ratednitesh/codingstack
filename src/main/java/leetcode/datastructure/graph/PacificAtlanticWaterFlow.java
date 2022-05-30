package main.java.leetcode.datastructure.graph;

import java.util.*;

/***************************
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 ****************************/
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        Queue<int[]> queuePacific = new LinkedList<>();
        Queue<int[]> queueAtlantic = new LinkedList<>();
        boolean[][] isVisitedP = new boolean[m][n];
        boolean[][] isVisitedA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            queuePacific.offer(new int[]{i, 0});
            queueAtlantic.offer(new int[]{i, n - 1});
            isVisitedP[i][0] = true;
            isVisitedA[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            queuePacific.offer(new int[]{0, j});
            isVisitedP[0][j] = true;
            queueAtlantic.offer(new int[]{m - 1, j});
            isVisitedA[m - 1][j] = true;
        }
        bfs(queuePacific, heights, m, n, isVisitedP);
        bfs(queueAtlantic, heights, m, n, isVisitedA);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisitedA[i][j] && isVisitedP[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    public static void bfs(Queue<int[]> queue, int[][] heights, int m, int n, boolean[][] isVisited) {
        int[][] helperGrid = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] indexes = queue.poll();
                for (int[] h : helperGrid) {
                    int x = indexes[0] + h[0];
                    int y = indexes[1] + h[1];
                    if (x < m && y < n && x >= 0 && y >= 0 && !isVisited[x][y] && heights[x][y] >= heights[indexes[0]][indexes[1]]) {
                        isVisited[x][y] = true;
                        queue.offer(new int[]{x, y});

                    }
                }
            }
        }
    }

    // DFS Solution
    public List<int[]> pacificAtlanticDFS(int[][] matrix) {
        List<int[]> res = new LinkedList<>();

        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, m, n, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, m, n, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, m, n, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, m, n, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i, j});
        return res;
    }

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] matrix, int m, int n, boolean[][] visited, int height, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(matrix, m, n, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
}
