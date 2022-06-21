package main.java.core;

import java.util.ArrayList;
import java.util.List;

/***************************
 * Find all contiguous subArray of an Array
 ****************************/
public class FindAllPartitions {

    public static void main(String[] args) {
        allPartitions(new int[]{1, 2, 3});
        System.out.println(finalResult);
    }

    public static void allPartitions(int[] arr) {
        int n = arr.length;

        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        allPartitions(result, arr, 0, n);
    }

    public static List<List<List<Integer>>> finalResult = new ArrayList<>();

    public static void allPartitions(List<List<Integer>> result, int[] arr, int index, int n) {
        if (index == n)
            return;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n && index + i < n; i++) {

            list.add(arr[index + i]);
            result.add(new ArrayList<>(list));
            //
            allPartitions(new ArrayList<>(result), arr, index + i + 1, n);
            if (index + i + 1 == n)
                finalResult.add(new ArrayList<>(result));
            result.remove(result.size() - 1);

        }
        System.out.println(list + " " + index);
        // System.out.println(result);

    }
}
