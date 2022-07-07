package main.java.leetcode.datatype.numbers;

import java.util.PriorityQueue;

/***************************
* https://leetcode.com/problems/super-ugly-number/
****************************/
public class SuperUglyNumbers {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] res = new long[n]; // dp array
        res[0] = 1; // initialize first index with 1
        int[] cur = new int[primes.length]; // this will have indexes

        for (int i = 1; i < n; i++) { // set values for dp array
            res[i] = Integer.MAX_VALUE; // initialize
            for (int j = 0; j < primes.length; j++) { // iterate over list of primes
                if (primes[j] * res[cur[j]] == res[i - 1]) { // duplication case
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j] * res[cur[j]]); // find the next ugly number using the previously found ugly numbers
            }
        }
        return (int) res[n - 1]; // final value for nth super ugly number in last element of dp array
    }
    // using PQ
    public int nthSuperUglyNumberPQ(int n, int[] primes) {
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> (int) (a[0] - b[0]));
        for (int i = 0; i < primes.length; i++)
            queue.offer(new long[]{primes[i], primes[i], 0});

        int[] nums = new int[n + 1];
        nums[0] = 1;

        int i = 1;
        while (i < n) {
            long[] entry = queue.poll();
            long num = entry[0], prime = entry[1], index = entry[2];
            // remove duplicate
            if (num != nums[i - 1]) {
                nums[i] = (int) num;
                i++;
            }
            queue.offer(new long[]{prime * (long) nums[(int) (index + 1)], prime, (index + 1)});
        }
        return nums[n - 1];
    }
}
