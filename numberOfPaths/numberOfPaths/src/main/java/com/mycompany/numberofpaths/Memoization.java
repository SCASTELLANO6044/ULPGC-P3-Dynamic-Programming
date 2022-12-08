package com.mycompany.numberofpaths;

import java.util.HashMap;
import java.util.Map;

public class Memoization {
    
    /**
     * @param matrix - matriz a la que se le aplicará el problema de memoization
     * @param givenCost - coste a buscar para encontrar alguna ruta
    */
    public static void findNumberOfPathsMemoization(int[][] matrix, int givenCost) {
        
        /**
         * long start: almacena el momento en el que comienza la ejecución del 
         *             método en ns.
         * 
         * Map<String, Integer> dict: contenedor que almacena la ruta y el coste 
         *                            de esta.
        */        
        long start = System.nanoTime();
        Map<String, Integer> dict = new HashMap<>();
        
        Data.setPaths(countPaths(matrix, matrix.length - 1, matrix[0].length - 1, givenCost, dict));
        Data.setTime(String.format("%.2f", (double) (System.nanoTime() - start)/1_000_000_000));
    }

    /**
     * @param matrix - matriz a la que se le aplicará el problema
     * @param m - nº de filas de la matriz
     * @param n - nº de columnas de la matriz
     * @param cost - coste restante para encontrar alguna ruta
     * @param dict - diccionario
     * @return Número de caminos para alcanzar la celda (m, n)
    */
    private static int countPaths(int[][] matrix, int m, int n, int cost, Map<String, Integer> dict) {
        
        // Caso base
        if (cost < 0) {
            return 0;
        }
        
        // Si estamos en la primera celda (0, 0)
        if (m == 0 && n == 0) {
            return (matrix[0][0] - cost == 0) ? 1 : 0;
        }

        String key = "(" + m + ", " + n + ") - " + cost;
        
        /**
         * Si el diccionario no contiene la clave, significa que el subproblema 
         * no ha sido tratado aún
        */
        if (!dict.containsKey(key)) {
            // Si estamos en la primera fila, solo podremos avanzar hacia la izquierda en las columnas
            if (m == 0) {
                dict.put(key, countPaths(matrix, 0, n - 1, cost - matrix[m][n], dict));
            }
            // Si estamos en la primera columna, solo podremos avanzar hacia arriba en las filas
            else if (n == 0) {
                dict.put(key, countPaths(matrix, m - 1, 0, cost - matrix[m][n], dict));
            }
            // En cualquier otro caso, podemos avanzar tanto a la izquerda en las columnas, como arriba en las filas
            else {
                dict.put(key, countPaths(matrix, m - 1, n, cost - matrix[m][n], dict) + countPaths(matrix, m, n - 1, cost - matrix[m][n], dict));
            }
        }
        
        // Devolvemos el nº de rutas posibles para llegar a la celda (m, n)
        return dict.get(key);
    }
}