package main.java.leetcode.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 ****************************/
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int top = 0;
        int bottom = 0;
        List<Integer> h = new ArrayList<>();

        while (true) {
            if (top >= nums1.length || bottom >= nums2.length) {
                break;
            }
            if (nums1[top] == nums2[bottom]) {
                h.add(nums1[top]);
                top++;
                bottom++;
            } else if (nums1[top] < nums2[bottom]) {
                top++;
            } else if (nums1[top] > nums2[bottom]) {
                bottom++;
            }
        }

        int[] g = new int[h.size()];
        for (int i = 0; i < h.size(); i++) {
            g[i] = h.get(i);
        }
        return g;

    }
    /* TODO: Follow ups: https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82243/Solution-to-3rd-follow-up-question
    What if elements of nums2 are stored on disk, and the memory is
    limited such that you cannot load all elements into the memory at
    once?

    If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

    If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record   intersections.
    The following video clearly explains how does external-sort work
    https://www.youtube.com/watch?v=Bp7fGofslng.
    */
}
