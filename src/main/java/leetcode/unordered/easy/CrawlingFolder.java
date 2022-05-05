package main.java.leetcode.unordered.easy;

/***************************
 * https://leetcode.com/problems/crawler-log-folder/
 ****************************/
public class CrawlingFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations(logs));
        String[] logs2 = {"./", "../", "./"};
        System.out.println(minOperations(logs2));
    }

    public static int minOperations(String[] logs) {
        int count = 0;
        for (String s : logs) {
            if (s.equals("../")) {
                if (count > 0)
                    count--;
            } else if (!s.equals("./"))
                count++;
        }
        return count;
    }
}
