package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 * #bitwise
 ****************************/

public class MaximumProductsOfWordLength {

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }

    public static int maxProduct(String[] words) {
        // Logic
        // int[words.length][26]
        // update this array -> N*M
        // improve this solution using BitWise:
        // for each string -> compute bitwise version for acd -> 1011 will be the bit
        // compare all elements in the resultant array to find max product-> n^2
        // to check no common char in two strings verify if bitwise#1 & bitwise#2 == 0
        int[] bitValues = new int[words.length];
        for (int i = 0; i < words.length; i++) { // O(M*N)
            for (char c : words[i].toCharArray())
                bitValues[i] |= 1 << c - 'a';
            System.out.println(words[i] + "->" + bitValues[i] + "->" + Integer.toBinaryString(bitValues[i]));
        }

        int maxProduct = 0;
        for (int i = 0; i < bitValues.length - 1; i++) {
            for (int j = i + 1; j < bitValues.length; j++)
                if ((bitValues[i] & bitValues[j]) == 0)
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
        }
        return maxProduct;
    }
}
