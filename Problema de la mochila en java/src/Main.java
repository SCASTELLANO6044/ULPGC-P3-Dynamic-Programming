import java.util.*;


public class Main {

    public static void main(String[] args) {
        List<BackpackItem> backpackItemList = new ArrayList<>();
        backpackItemList.add(new BackpackItem(2,3,4));
        backpackItemList.add(new BackpackItem(3,4,3));
        backpackItemList.add(new BackpackItem(4,5,2));
        backpackItemList.add(new BackpackItem(5,6,1));

        Integer capacity = 5;

        Map<Index, Integer> memo = new HashMap<>();


        System.out.println("Memoization Result: "+ memoization(backpackItemList, capacity, memo));

        System.out.println("Tabulation result: "+tabulation(backpackItemList, capacity));

    }

    private static Integer memoization(List<BackpackItem> backpackItemList, Integer capacity, Map<Index, Integer> memo){
        Index index = new Index(backpackItemList.size(), capacity);
        if (memo.containsKey(index)){
            System.out.println("Found in dictionary");
            return memo.get(index);
        }
        Integer result;
        if (backpackItemList.size() == 0){
            return 0;
        }
        if (backpackItemList.get(0).getWeight() > capacity) {
            List<BackpackItem> backpackItemListCopy = new ArrayList<>(backpackItemList);
            backpackItemListCopy.remove(0);
            result = memoization(backpackItemListCopy ,capacity, memo);
        }else {
            BackpackItem itemEvaluated = backpackItemList.get(0);
            List<BackpackItem> backpackItemListCopy = new ArrayList<>(backpackItemList);
            backpackItemListCopy.remove(0);
            Integer notTakenItem = memoization(backpackItemListCopy, capacity, memo);
            Integer takenItem = memoization(backpackItemListCopy, capacity - itemEvaluated.getWeight(), memo) + itemEvaluated.getBenefit();
            result = maximum (notTakenItem, takenItem);
        }
        memo.put(index, result);
        return result;
    }
    private static Integer tabulation (List<BackpackItem> backpackItemList, Integer capacity){
        int[][] table  = new int[backpackItemList.size()+1] [capacity + 1];

        Arrays.fill(table[0], 0);

        for (int i = 0; i < table.length; i++){
            table[i][0] = 0;
        }

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

        return table[table.length-1][table[0].length-1];
    }

    private static Integer maximum(Integer a, Integer b){
        if (a > b){
            return a;
        }
        return b;
    }

    private record Index(int i, int w) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return i == index.i && w == index.w;
        }


    }
}