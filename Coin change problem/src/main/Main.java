package main;

import dynamicprogramming.Memoization;
import dynamicprogramming.Tabulation;
import utils.Description;
import utils.FileInputReader;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Description description = new FileInputReader().read("C:\\GitHubProjects\\ULPGC-P3-Dynamic-Programming\\Coin change problem\\src\\input\\1.txt");

        Map<String, Integer> memory = new HashMap<>();
        int numOfCombinations = Memoization.execute(description.getCoinTypeArray(),
                description.getCoinTypeArray().length - 1, description.getSum(), memory);
        System.out.println(numOfCombinations);

        int tabulation = Tabulation.execute(description.getCoinTypeArray(), description.getSum());
        System.out.println(tabulation);
    }
}