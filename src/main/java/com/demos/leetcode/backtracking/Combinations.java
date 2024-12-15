package com.demos.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; ++i) {
            combination.add(i);
            backtrack(i + 1, n, k, combination, result);
            combination.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> res = combinations.combine(4, 3);
        System.out.println(res);
    }
}
