package dynamicprogramming;

public class Tabulation {

    private Tabulation(){}

    public static int execute(int[] coins, Integer sum) {
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
        return table[n][sum];
    }
}
