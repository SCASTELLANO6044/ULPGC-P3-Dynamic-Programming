import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer [] coins = {1, 2, 3};
        System.out.println(Tabulation.calculate(coins, 4));

        int coinTypeAmount = 3;
        int sum = 9;
        int[][] dp = new int[coinTypeAmount + 1][sum + 1];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        int res = Memoization.calculate(coins, sum, coinTypeAmount, dp);
        System.out.println(res);
        System.out.println(Arrays.deepToString(dp));
    }
}