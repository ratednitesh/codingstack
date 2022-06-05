package main.java.gs;

import java.util.HashSet;
import java.util.LinkedHashSet;

/***************************
 * #numberOperations
 ****************************/
public class DecimalConversion {
    public static void main(String[] args) {
        System.out.println(decimalConversion(-1, 11));
    }

    public static String decimalConversion(int n, int d) {
        if (d == 0) return "NaN";
        if (n == 0) return "0";
        StringBuilder result = new StringBuilder();
        if (n * d < 0)
            result.append("-");
        n = Math.abs(n);
        d = Math.abs(d);
        HashSet<Integer> hs = new LinkedHashSet<>();
        result.append(n / d); // add the left of decimal to result
        int r = n % d;
        if (r != 0) // if the remainder is their add decimal pointer
            result.append(".");
        else
            return result.toString();
        n = r * 10;
        int remBreak = -1;
        while (n != 0) {
            if (!hs.add(r)) {
                remBreak = r;
                break;
            }
            r = n % d;
            n = r * 10;
        }

        for (int s : hs) {
            if (s == remBreak)
                result.append("(");
            result.append(s * 10 / d);
        }
        if (remBreak != -1)
            result.append(")");
        return result.toString();
    }

}
