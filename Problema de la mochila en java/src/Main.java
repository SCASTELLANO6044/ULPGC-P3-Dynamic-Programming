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

        Integer backpack = memoization(backpackItemList, capacity, memo);

        System.out.println(backpack);
    }

    private static Integer memoization(List<BackpackItem> backpackItemList, Integer capacity, Map<Index, Integer> memo){
        Index index = new Index(backpackItemList.size(), capacity);
        if (memo.containsKey(index)){
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
        return result;
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