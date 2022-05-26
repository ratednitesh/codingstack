package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 ****************************/
public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, n = letters.length, end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        return letters[start % n];
    }
}
