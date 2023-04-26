import java.util.*;

public class Memoization {
    public static Integer execute(List<BackpackItem> backpackItemList, Integer capacity, Integer positionIterator, Map<Memoization.Index, Integer> memo){
        Memoization.Index index = new Index(positionIterator, capacity);
        if (memo.containsKey(index)){
            return memo.get(index);
        }
        Integer result;
        int currentPositionToEvaluate = backpackItemList.size() - positionIterator;
        if (positionIterator == 0){
            return 0;
        }
        if (backpackItemList.get(currentPositionToEvaluate).getWeight() > capacity) {
            positionIterator --;
            result = execute(backpackItemList ,capacity, positionIterator, memo);
        }else {
            BackpackItem itemEvaluated = backpackItemList.get(currentPositionToEvaluate);
            positionIterator --;
            Integer notTakenItem = execute(backpackItemList, capacity, positionIterator, memo);
            Integer takenItem = execute(backpackItemList, capacity - itemEvaluated.getWeight(),positionIterator, memo) + itemEvaluated.getBenefit();
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
