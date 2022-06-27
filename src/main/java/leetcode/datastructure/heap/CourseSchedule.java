package main.java.leetcode.datastructure.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/course-schedule/
 ****************************/
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(3, new int[][]{{0, 1}, {2, 1}}));
    }

    // Topological Sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            int course = p[0];
            int preCourse = p[1];
            if (matrix[preCourse][course] == 0)
                degree[course]++;
            matrix[preCourse][course] = 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        System.out.println(Arrays.toString(degree));
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--degree[i] == 0)
                        queue.offer(i);
                }
            }
            count++;
        }
        System.out.println(count);
        return count == numCourses;
    }
}
