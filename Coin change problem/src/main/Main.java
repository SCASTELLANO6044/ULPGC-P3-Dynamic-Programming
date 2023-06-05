package main;

import dynamicprogramming.Memoization;
import dynamicprogramming.Tabulation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int [] coins = {1, 2, 3};
        Map<String, Integer> memory = new HashMap<>();

        int numOfCombinations = Memoization.execute(coins, coins.length-1, 4, memory);
        System.out.println(numOfCombinations);

        int tabulation = Tabulation.execute(coins, 4);
        System.out.println(tabulation);
    }
}