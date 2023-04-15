import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer [] coins = {1, 2, 3};
        Map<String, Integer> memory = new HashMap<>();
        System.out.println(memoization(coins, coins.length-1, 4, memory));
        System.out.println(tabulation(coins, 9));
    }

    private static Integer memoization (Integer[] coins, Integer coinTypeNum, Integer sum, Map<String, Integer> memory){
        if (sum == 0){
            return 1;
        }
        if (sum < 0 || coinTypeNum < 0){
            return 0;
        }
        String key = coinTypeNum + "->"+sum;
        if (!memory.containsKey(key)){
            Integer taken = memoization(coins, coinTypeNum, sum - coins[coinTypeNum], memory);
            Integer notTaken = memoization(coins, coinTypeNum-1, sum, memory);
            memory.put(key, taken+notTaken);
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