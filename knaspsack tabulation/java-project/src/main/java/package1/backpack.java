package package1;

public class backpack {
    
    private int [][] items;
    private final int maxWreight;
    private final int numItems;
    private int [][] table;
    
    public backpack(int[][] items, int maxWeight){
        this.items=items;
        this.maxWreight=maxWeight;
        this.numItems = items.length;
        this.table = new int [6][5];
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
        // Caso base 1 si numItems <=0 funcion = 0
        for (int i = 0; i < this.table[0].length; i++) {
            this.table[0][i] = 1;
        }
        //Caso base la mochila no tiene capacidad.
        for (int i = 0; i < this.table.length; i++) {
            this.table[i][0] = 1;
        }
        debugArray(table);
        
    }
    
    private void debugArray(int [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
