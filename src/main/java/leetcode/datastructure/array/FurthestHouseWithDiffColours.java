package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 ****************************/
public class FurthestHouseWithDiffColours {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 6, 1, 1, 1, 1};
        System.out.println(maxDistance(arr));
    }

    public static int maxDistance(int[] colors) {
        if (colors.length == 2) {
            return colors[0] == colors[1] ? 0 : 1;
        }
        int i = 0, j = colors.length - 1;
        while (i < colors.length) {
            if (colors[0] == colors[j])
                j--;
            else
                return j;
            if (colors[colors.length - 1] == colors[i])
                i++;
            else
                return colors.length - i - 1;
        }
        return 0;
    }
}
