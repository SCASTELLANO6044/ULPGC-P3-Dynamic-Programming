import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<BackpackItem> backpackItemList = new ArrayList<>();
        backpackItemList.add(new BackpackItem(2,3,4));
        backpackItemList.add(new BackpackItem(3,4,3));
        backpackItemList.add(new BackpackItem(4,5,2));
        backpackItemList.add(new BackpackItem(5,6,1));

        Integer capacity = 5;

        Integer backpack = memoization(backpackItemList, capacity);

        System.out.println(backpack);
    }

    private static Integer memoization(List<BackpackItem> backpackItemList, Integer capacity){
        Integer result;
        if (backpackItemList.size() == 0){
            return 0;
        }
        if (backpackItemList.get(0).getWeight() > capacity) {
            List<BackpackItem> backpackItemListCopy = new ArrayList<>(backpackItemList);
            backpackItemListCopy.remove(0);
            result = memoization(backpackItemListCopy ,capacity);
        }else {
            BackpackItem itemEvaluated = backpackItemList.get(0);
            List<BackpackItem> backpackItemListCopy = new ArrayList<>(backpackItemList);
            backpackItemListCopy.remove(0);
            Integer notTakenItem = memoization(backpackItemListCopy, capacity);
            Integer takenItem = memoization(backpackItemListCopy, capacity - itemEvaluated.getWeight()) + itemEvaluated.getBenefit();
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
}