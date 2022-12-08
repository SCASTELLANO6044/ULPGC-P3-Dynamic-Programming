package com.mycompany.numberofpaths;

public class Tabulation {
    
    /**
     * @param matrix - matriz a la que se le aplicará el problema de tabulation
     * @param givenCost - coste a buscar
    */
    public static void findNumberOfPathsTabulation(int[][] matrix, int givenCost) {
        long start = System.nanoTime();

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int [][][]tab = new int[rows][cols][givenCost + 1];
        
        if (matrix[0][0] > givenCost) Data.setPaths(0);
        tab[0][0][matrix[0][0]] = 1;

        int currentCost = 0;
        for (int i = 0; i < rows; i++) {
            currentCost += matrix[i][0];
            if (currentCost <= givenCost) tab[i][0][currentCost] = 1;
        }

        currentCost = 0;
        for (int i = 0; i < cols; i++) {
            currentCost += matrix[0][i];
            if (currentCost <= givenCost) tab[0][i][currentCost] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                for (int k = 0; k <= givenCost; k++) {
                    if (k - matrix[i][j] >= 0) tab[i][j][k] = tab[i - 1][j][k - matrix[i][j]] + tab[i][j - 1][k - matrix[i][j]];
                }
            }
        }

        Data.setPaths(tab[rows - 1][cols - 1][givenCost]);
        Data.setTime(String.format("%.2f", (double) (System.nanoTime() - start)/1_000_000_000));
    }
}
