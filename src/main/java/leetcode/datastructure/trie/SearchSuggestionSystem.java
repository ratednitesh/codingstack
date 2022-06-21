package main.java.leetcode.datastructure.trie;

import java.util.*;

/***************************
 * https://leetcode.com/problems/search-suggestions-system/
 ****************************/
public class SearchSuggestionSystem {
    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[]{"havana"}, "ty"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            int firstFoundIndex = binarySearch(products, prefix);
            List<String> l = new ArrayList<>();
            for (int j = firstFoundIndex; j < products.length && l.size() < 3; ++j) {
                if (products[j].startsWith(prefix)) {
                    l.add(products[j]);
                } else
                    break;
            }
            list.add(l);
        }
        return list;
    }

    static int left = 0;

    static int binarySearch(String[] products, String prefix) {
        int right = products.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (products[mid].compareTo(prefix) >= 0)
                right = mid - 1;//else will execute if products[mid] is before the prefix
            else left = mid + 1;
        }
        return left = right + 1;
    }

    // PriorityQueue Solution
    public List<List<String>> suggestedProductsPQ(String[] products, String searchWord) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(3, Comparator.reverseOrder());
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String s = searchWord.substring(0, i + 1);
            for (String p : products) {
                if (p.startsWith(s)) {
                    priorityQueue.offer(p);
                }
                if (priorityQueue.size() > 3)
                    priorityQueue.poll();
            }
            List<String> list = new LinkedList<>();
            while (!priorityQueue.isEmpty())
                list.add(0, priorityQueue.poll());
            result.add(list);
        }
        return result;
    }

    // TODO: Trie solution understand below fully
    public List<List<String>> suggestedProductsTrie(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product : products) insert(root, product);

        List<List<String>> results = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if ((root = root.children[c - 'a']) == null) break;
            results.add(root.getTopThree());
        }

        while (results.size() < searchWord.length())
            results.add(new ArrayList<>());
        return results;
    }

    private void insert(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null)
                root.children[c - 'a'] = new TrieNode();
            root = root.children[c - 'a'];
            root.addToPQ(word);
        }
    }
    // TODO: Trie Solution using sorting instead of PQ.
}

class TrieNode {
    public TrieNode[] children;
    public PriorityQueue<String> pq;

    public TrieNode() {
        children = new TrieNode[26];
        pq = new PriorityQueue<>(Comparator.reverseOrder()); //max Heap
    }

    public void addToPQ(String word) {
        pq.add(word);
        if (pq.size() > 3) pq.poll();
    }

    public List<String> getTopThree() {
        List<String> topThree = new ArrayList<>();
        while (!pq.isEmpty()) topThree.add(pq.poll());
        Collections.reverse(topThree);
        return topThree;
    }
}