import java.util.*;

public class Memoization {
    public static Integer execute(List<BackpackItem> backpackItemList, Integer capacity, Map<Memoization.Index, Integer> memo){
        Memoization.Index index = new Index(backpackItemList.size(), capacity);
        if (memo.containsKey(index)){
            //System.out.println("Found in dictionary");
            return memo.get(index);
        }
        Integer result;
        if (backpackItemList.size() == 0){
            return 0;
        }
        if (backpackItemList.get(0).getWeight() > capacity) {
            List<BackpackItem> backpackItemListCopy = new ArrayList<>(backpackItemList);
            backpackItemListCopy.remove(0);
            result = execute(backpackItemListCopy ,capacity, memo);
        }else {
            BackpackItem itemEvaluated = backpackItemList.get(0);
            List<BackpackItem> backpackItemListCopy = new ArrayList<>(backpackItemList);
            backpackItemListCopy.remove(0);
            Integer notTakenItem = execute(backpackItemListCopy, capacity, memo);
            Integer takenItem = execute(backpackItemListCopy, capacity - itemEvaluated.getWeight(), memo) + itemEvaluated.getBenefit();
            result = maximum (notTakenItem, takenItem);
        }
        memo.put(index, result);
        return result;
    }

    private static Integer maximum(Integer a, Integer b){
        if (a > b){
            return a;
        }
        return b;
    }

    public record Index(int i, int w) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Memoization.Index index = (Memoization.Index) o;
            return i == index.i && w == index.w;
        }
    }
}
