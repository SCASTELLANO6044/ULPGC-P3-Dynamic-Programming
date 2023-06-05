package main;

import dynamicprogramming.Memoization;
import dynamicprogramming.Tabulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer [] coins = {1, 2, 3};
        Map<String, List<List<Integer>>> memory = new HashMap<>();
        List<List<Integer>> combinations = Memoization.execute(coins, coins.length-1, 4, memory);
        Integer numOfCombinations = combinations.size();
        System.out.println(numOfCombinations);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }

        List<List<Integer>> tabulation = Tabulation.execute(coins, 4);
        System.out.println(tabulation);
    }
}