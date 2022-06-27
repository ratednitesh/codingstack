package main.java.leetcode.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/course-schedule-iii/
 ****************************/
public class CourseSchedule3 {
    public static void main(String[] args) {

    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            priorityQueue.add(course[0]);
            if (time > course[1]) {
                time -= priorityQueue.poll(); // remove the course taking max time
            }
        }
        return priorityQueue.size();
    }

}
