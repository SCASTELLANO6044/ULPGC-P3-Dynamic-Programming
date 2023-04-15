import java.util.Arrays;

public class Tabulation {
    public static Integer calculate(Integer[]coins, int sum){
        Integer[] table = new Integer[sum +1];
        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= sum; j++)
                table[j] += table[j - coins[i]];

        return table[sum];
    }
}
