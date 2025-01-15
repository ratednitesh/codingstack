package main.java.core.searching;

/***************************
 * suppose we have an array arr[] of size n and a block (to be jumped) of size m. Then we search in the indexes arr[0], arr[m], arr[2m]…..arr[km] and so on. Once we find the interval (arr[km] < x < arr[(k+1)m]), we perform a linear search operation from the index km to find the element x.
 ****************************/
public class JumpSearch {
    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n)); // In the worst case, we have to do n/m jumps, and if the last checked value is greater than the element to be searched for, we perform m-1 comparisons more for linear search. Therefore, the total number of comparisons in the worst case will be ((n/m) + m-1). The value of the function ((n/m) + m-1) will be minimum when m = √n. Therefore, the best step size is m = √n.

        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x) {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (arr[prev] == x)
            return prev;

        return -1;
    }

}
