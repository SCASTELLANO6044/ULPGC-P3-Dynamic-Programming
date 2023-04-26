import java.util.*;


public class Main {

    public static void main(String[] args) {
        List<BackpackItem> backpackItemList = new ArrayList<>();
        backpackItemList.add(new BackpackItem(2,3,4));
        backpackItemList.add(new BackpackItem(3,4,3));
        backpackItemList.add(new BackpackItem(4,5,2));
        backpackItemList.add(new BackpackItem(5,6,1));

        Integer capacity = 5;

        Map<Memoization.Index, Integer> memo = new HashMap<>();

        System.out.println("New Memoization Result: " + Memoization.execute(backpackItemList, capacity, backpackItemList.size(), memo));

        System.out.println("Tabulation result: " + Tabulation.execute(backpackItemList, capacity));

    }
}