package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Memoization {

    private Memoization(){}

    public static List<List<Integer>> execute(Integer[] coins, Integer coinTypeNum, Integer sum, Map<String, List<List<Integer>>> memory){
        if (sum == 0){
            List<List<Integer>> combinations = new ArrayList<>();
            combinations.add(new ArrayList<>());
            return combinations;
        }
        if (sum < 0 || coinTypeNum < 0){
            return new ArrayList<>();
        }
        String key = coinTypeNum + "->"+sum;
        if (!memory.containsKey(key)){
            List<List<Integer>> takenCombinations = execute(coins, coinTypeNum, sum - coins[coinTypeNum], memory);
            List<List<Integer>> notTakenCombinations = execute(coins, coinTypeNum-1, sum, memory);
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

}
