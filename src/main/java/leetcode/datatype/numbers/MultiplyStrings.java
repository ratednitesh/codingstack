package main.java.leetcode.datatype.numbers;

import java.util.ArrayList;

/***************************
 * https://leetcode.com/problems/multiply-strings/
 ****************************/
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(bestMultiply("123", "456"));
        System.out.println(multiply("123", "456"));
    }

    // Using Array and StringBuilder
    public static String bestMultiply(String num1, String num2) {
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int index1 = i + j;
                int index2 = i + j + 1;
                int sum = mul + ans[index2];
                ans[index1] += sum / 10;
                ans[index2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            if (!(sb.length() == 0 && i == 0)) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    // using ArrayList
    public static String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int bitProduct;
            int index = num1.length() - 1 - i;
            for (int j = num2.length() - 1; j >= 0; j--) {
                bitProduct = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                if (index < list.size()) {
                    bitProduct += list.get(index);
                    list.set(index, bitProduct % 10);
                } else
                    list.add(index, bitProduct % 10);
                if (index + 1 < list.size()) {
                    bitProduct += list.get(index + 1) * 10;
                    list.set(index + 1, bitProduct / 10);
                } else if (bitProduct / 10 > 0)
                    list.add(index + 1, bitProduct / 10);
                index++;
            }
        }
        for (int n : list) {
            result.insert(0, n);
        }
        return result.toString();
    }

}
