import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer [] coins = {1, 2, 3};
        Map<String, List<List<Integer>>> memory = new HashMap<>(); // Cambio de valor de retorno a lista de listas
        List<List<Integer>> combinations = memoization(coins, coins.length-1, 4, memory);
        Integer numOfCombinations = combinations.size();
        System.out.println(numOfCombinations);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    private static List<List<Integer>> memoization (Integer[] coins, Integer coinTypeNum, Integer sum, Map<String, List<List<Integer>>> memory){
        if (sum == 0){
            List<List<Integer>> combinations = new ArrayList<>();
            combinations.add(new ArrayList<>());
            return combinations;
        }
        if (sum < 0 || coinTypeNum < 0){
            List<List<Integer>> combinations = new ArrayList<>();
            return combinations;
        }
        String key = coinTypeNum + "->"+sum;
        if (!memory.containsKey(key)){
            List<List<Integer>> takenCombinations = memoization(coins, coinTypeNum, sum - coins[coinTypeNum], memory);
            List<List<Integer>> notTakenCombinations = memoization(coins, coinTypeNum-1, sum, memory);
            List<List<Integer>> combinations = new ArrayList<>();
            for (List<Integer> combination : takenCombinations) {
                List<Integer> takenCombination = new ArrayList<>(combination);
                takenCombination.add(coins[coinTypeNum]);
                combinations.add(takenCombination);
            }
            combinations.addAll(notTakenCombinations);
            memory.put(key, combinations);
        }
        return memory.get(key);
    }

    private static Integer tabulation (Integer[] coins, Integer sum){
        int n = coins.length;

        int[][] table = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                }
                else {
                    table[i][j] = table[i - 1][j] + table[i][j - coins[i - 1]];
                }
            }
        }

        return table[n][sum];
    }
}