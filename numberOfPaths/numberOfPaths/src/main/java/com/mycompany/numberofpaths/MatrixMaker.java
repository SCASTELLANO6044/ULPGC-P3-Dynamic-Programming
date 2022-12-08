package com.mycompany.numberofpaths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class MatrixMaker {
    /**
     * @param fileName - Nombre del fichero que se leerá
     * @throws Exception
    */    
    public static int[][] createMatrix(String fileName) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
        int[][] matrix = new int[0][0];
        while (sc.hasNextInt()) {
            Data.setRows(sc.nextInt());
            Data.setCols(sc.nextInt());
            Data.setCost(sc.nextInt());

            matrix = new int[Data.getRows()][Data.getCols()];

            for (int i = 0; i < Data.getRows(); i++){
                for (int j = 0; j < Data.getCols(); j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
        }
        return matrix;
    }
    
    /**
     * @param matrix - matriz a copiar
     * @return nueva matriz con copia en profundidad
    */
    public static int[][] deepCopy(int[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }
    
}