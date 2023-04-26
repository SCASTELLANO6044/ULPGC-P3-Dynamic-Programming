import java.util.ArrayList;
import java.util.List;

public class Tabulation {

    public static Integer execute(List<BackpackItem> backpackItemList, Integer capacity){
        int[][] table  = new int[backpackItemList.size()+1] [capacity + 1];

        for (int i = 1; i < table.length; i++){
            for (int w = 1; w < table[0].length; w++){
                table[i][w] = 1;
                if (backpackItemList.get(i-1).getWeight() <= w ){
                    Integer notTaken = table[i-1][w];
                    Integer taken = backpackItemList.get(i-1).getBenefit() + table[i-1][w - backpackItemList.get(i-1).getWeight()];
                    table[i][w] = maximum(notTaken, taken);
                }else {
                    table[i][w] = table[i -1][w];
                }
            }
        }

        //TODO: TRATAR DE ADAPTARLO EN MEMOIZATION DE LA MISMA MANERA
        //TODO: CORREGIR
        int i = table.length-1;
        int k = table[0].length-1;
        List<Integer> selectedItems = new ArrayList<>();
        while (i > 0 && k > 0){
            if(table[i][k] != table[i-1][k]){
                selectedItems.add(i);
                i--;
                k = k - table[i][k];
            }else {
                i--;
            }
        }

        System.out.println("Elements taken in tabulation: " + selectedItems);

        return table[table.length-1][table[0].length-1];
    }

    private static Integer maximum(Integer a, Integer b){
        if (a > b){
            return a;
        }
        return b;
    }

}
