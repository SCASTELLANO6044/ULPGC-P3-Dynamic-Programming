package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Tabulation {

    private Tabulation(){}

    public static List<List<Integer>> execute(Integer[] coins, Integer sum) {
        int n = coins.length;
        int[][] table = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < table[n].length; i++) {
            result.add(getCombinations(table, coins, n, i));
        }
        return result;
    }

    private static List<Integer> getCombinations(int[][] table, Integer[] coins, int i, int j) {
        List<Integer> combinations = new ArrayList<>();
        while (i > 0 && j >= 0) {
            if (table[i - 1][j] == table[i][j]) {
                i--;
            } else {
                combinations.add(coins[i - 1]);
                j -= coins[i - 1];
            }
        }
        return combinations;
    }
}
