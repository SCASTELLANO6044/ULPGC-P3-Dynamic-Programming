package package1;

public class backpack {
    
    private int [][]items;
    private int maxWreight;
    private int numItems;
    
    public backpack(int[][] items, int maxWeight){
        this.items=items;
        this.maxWreight=maxWeight;
        this.numItems = items.length;
    }

    public int[][] getItems() {
        return items;
    }

    public int getMaxWreight() {
        return maxWreight;
    }

    public int getNumItems() {
        return numItems;
    }
    
    public void getBestCombination(){
        
    }
}
