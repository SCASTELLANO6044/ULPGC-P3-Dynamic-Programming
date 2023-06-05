package org.example.dynamicprogramming;

import java.util.Map;

public class Memoization {

    private Memoization(){}

    public static int execute(int[] coins, int coinTypeNum, int sum, Map<String, Integer> memory){
        if (sum == 0){
            return 1;
        }
        if (sum < 0 || coinTypeNum < 0){
            return 0;
        }
        String key = coinTypeNum + "->"+sum;

        if (!memory.containsKey(key)){

            int include = execute(coins, coinTypeNum, sum - coins[coinTypeNum], memory);

            int exclude = execute(coins, coinTypeNum - 1, sum, memory);

            memory.put(key, include + exclude);
        }
        return memory.get(key);
    }

}
