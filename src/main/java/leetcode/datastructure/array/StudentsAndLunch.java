package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 ****************************/
public class StudentsAndLunch {
    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(countStudents(students, sandwiches));
    }

    // TODO: Implement using queue
    public static int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int s : students) {
            count[s]++;
        }
        for (int s : sandwiches) {
            if (count[s] > 0)
                count[s]--;
            else
                break;
        }
        return Math.max(count[0], count[1]);
    }
}
