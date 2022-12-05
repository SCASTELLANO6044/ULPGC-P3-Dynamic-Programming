package package1;

public class backpack {
    
    private int [][] items;
    private final int maxWreight;
    private int actualWeight;
    private final int numItems;
    private int [][] table;
    
    public backpack(int[][] items, int maxWeight){
        this.items=items;
        this.maxWreight=maxWeight;
        this.numItems = items.length;
        this.table = new int [5][6];
        this.actualWeight = 0;
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
            this.table[0][i] = 0;
        }
        //Caso base la mochila no tiene capacidad.
        for (int i = 0; i < this.table.length; i++) {
            this.table[i][0] = 0;
        }
        
        //Caso general escogemos opción con mayor beneficio.
        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (j <= table[0].length){
                    if ((items[i-1][1] + table[i-1][maxWreight-j]) > table[i-1][maxWreight]){
                        table[i][j] = items[i-1][1] + table[i-1][maxWreight-j];
                    }else{
                        table[i][j] = table[i-1][maxWreight];
                    }
                }else{
                    table[i][j] = table[i-1][j];
                }
            }
        }
        
    }
    
    private void debugArray(int [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println(array[i][j]);
            }
            System.out.println("-------");
        }
    }
}
