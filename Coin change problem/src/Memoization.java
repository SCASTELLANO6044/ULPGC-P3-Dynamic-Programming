public class Memoization {

    public static Integer calculate(Integer[] coins, int sum, int coinTypeAmount, int[][] dp){
        if (sum == 0){
            return dp[coinTypeAmount][sum] = 1;
        }
        if (coinTypeAmount == 0){
            return 0;
        }
        if (dp[coinTypeAmount][sum] != -1){
            return dp[coinTypeAmount][sum];
        }
        if (coins[coinTypeAmount - 1] <= sum) {
            // Either Pick this coin or not
            return dp[coinTypeAmount][sum]
                    = Memoization.calculate(coins, sum - coins[coinTypeAmount - 1], coinTypeAmount, dp)
                    + Memoization.calculate(coins, sum, coinTypeAmount - 1, dp);
        }
        else // We have no option but to leave this coin
            return dp[coinTypeAmount][sum] = Memoization.calculate(coins, sum, coinTypeAmount - 1, dp);
    }
}
