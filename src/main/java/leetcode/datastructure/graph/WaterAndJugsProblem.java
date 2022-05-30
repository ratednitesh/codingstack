package main.java.leetcode.datastructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/water-and-jug-problem/
 ****************************/
public class WaterAndJugsProblem {
    public static void main(String[] args) {
        System.out.println(new WaterAndJugsProblem().canMeasureWater(3, 5, 4));
    }

    static class State {
        int x, y;

        State(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x == z || y == z || x + y == z) return true;
        if (x + y < z) return false;
        if (x % 2 == 0 && y % 2 == 0 && z % 2 != 0)//cannot measure odd capacity using even capacity jugs
            return false;

        HashSet<String> visited = new HashSet<>();//state visited set of jugs
        State start = new State(0, 0);
        Queue<State> q = new LinkedList<>();
        q.add(start);
        //run a bfs. don't add already visited states
        while (q.size() > 0) {
            State curr = q.poll();
            if (curr.x + curr.y == z)
                return true;
            visited.add(curr.x + "," + curr.y);

            int newY, newX;
            //pour x->y ********************* option 1
            newX = curr.x - Math.min(curr.x, y - curr.y);
            newY = curr.y + Math.min(curr.x, y - curr.y);
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            //pour x<-y ********************* option 2
            newX = curr.x + Math.min(curr.y, x - curr.x);
            newY = curr.y - Math.min(curr.y, x - curr.x);
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            //empty x   ********************* option 3
            newX = 0;
            newY = curr.y;//same
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            //empty y   ********************* option 4
            newX = curr.x;//same
            newY = 0;
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            //fill x    ********************* option 5
            newX = x;//max capacity
            newY = curr.y;
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));

            //fill y    ********************* option 6
            newX = curr.x;
            newY = y;//max capacity
            if (!visited.contains(newX + "," + newY))
                q.add(new State(newX, newY));
        }
        return false;
    }


    /* Mathematical Solution
    This is a pure Math problem. We need the knowledge of number theory to cover the proof and solution. No idea why microsoft uses     this problem in real interview.

    The basic idea is to use the property of Bézout's identity and check if z is a multiple of GCD(x, y)

    Quote from wiki:

    Bézout's identity (also called Bézout's lemma) is a theorem in the elementary theory of numbers:

    let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
    and y such that ax+by=d

    In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by

    every integer of the form ax + by is a multiple of the greatest common divisor d.

    If a or b is negative this means we are emptying a jug of x or y gallons respectively.

    Similarly if a or b is positive this means we are filling a jug of x or y gallons respectively.
     */
    public boolean canMeasureWaterGCD(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) return false;
        //case x or y is zero
        if (x == z || y == z || x + y == z) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a, int b) { // 30, 21
        while (b != 0) {
            int temp = b; // temp = 21, temp = 9, temp =3
            b = a % b; // b= 9, 3, 0
            a = temp; // a = 21, 9, 3
        }
        return a; // 3
    }
}
