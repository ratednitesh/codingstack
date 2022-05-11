package main.java.leetcode.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/car-pooling/
 ****************************/
public class CarPooling {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 5}, {3, 5, 7}};
        System.out.println(carPooling(arr, 3));
    }

    // Approach 1: Using ArrayList
    public static boolean carPooling(int[][] trips, int capacity) {
        List<Integer> list = new ArrayList<>();
        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                if (trip[0] > capacity)
                    return false;
                if (i < list.size()) {
                    list.set(i, list.get(i) + trip[0]);
                    if (list.get(i) > capacity)
                        return false;
                } else {
                    while (i != list.size() - 1)
                        list.add(0);
                    list.set(i, trip[0]);
                }
            }
        }
        return true;
    }

    // Approach 2: Using Array
    public static boolean carPoolingOptimal(int[][] trips, int capacity) {
        int[] locations = new int[1001];
        for (int[] trip : trips) {
            locations[trip[1]] += trip[0];
            locations[trip[2]] -= trip[0];
        }
        int carLoad = 0;
        for (int location : locations) {
            carLoad += location;
            if (carLoad > capacity)
                return false;
        }
        return true;
    }
}
