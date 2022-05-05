package main.java.leetcode.operations.bitwise;

/***************************
 * https://leetcode.com/problems/add-binary/
 ****************************/
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;

        int carry = 0;
        while (l1 >= 0 || l2 >= 0 || carry != 0) {
            int sum = carry;
            if (l1 >= 0)
                sum += a.charAt(l1--) - '0';
            if (l2 >= 0)
                sum += b.charAt(l2--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}
