package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 ****************************/
public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 3, 5, 6, 1, 1, 1, 4}; //2,1,1,2
        System.out.println(timeRequiredToBuy(arr, 3));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int ticketsNeeded = tickets[k];
        int i = 0;
        int timeNeeded = ticketsNeeded;
        while (i < k) {
            timeNeeded += Math.min(ticketsNeeded, tickets[i]);
            i++;
        }
        i++;
        while (i < tickets.length) {
            timeNeeded += Math.min(ticketsNeeded - 1, tickets[i]);
            i++;
        }
        return timeNeeded;
    }
}
