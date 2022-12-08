package com.mycompany.numberofpaths;

public class Data {
    private static int rows, cols, cost, paths;
    private static String time;
    
    /**
     * @return Entero que representa el número de filas que contiene la matriz
    */
    public static int getRows() {
        return rows;
    }

    /**
     * @return Entero que representa el número de columnas que contiene la matriz
    */    
    public static int getCols() {
        return cols;
    }

    /**
     * @return Entero que representa el coste de la ruta
    */    
    public static int getCost() {
        return cost;
    }

    /**
     * @return Entero que representa el número de rutas encontradas
    */
    public static int getPaths() {
        return paths;
    }

    /**
     * @return Cadena de texto que almacena el tiempo transcurrido en la ejecución
     *         del programa
    */    
    public static String getTime() {
        return time;
    }
    
    /**
     * @param rows - núemro de filas que contiene la matriz
    */
    public static void setRows(int rows){ 
        Data.rows = rows; 
    }

    /**
     * @param cols - núemro de columnas que contiene la matriz
    */    
    public static void setCols(int cols){ 
        Data.cols = cols; 
    }
    
    /**
     * @param cost - coste calculado
    */
    public static void setCost(int cost){ 
        Data.cost = cost; 
    }
    
    /**
     * @param paths - número de rutas
    */
    public static void setPaths(int paths){ 
        Data.paths = paths; 
    }
    
    /**
     * @param time - tiempo de ejecución
    */
    public static void setTime(String time){ 
        Data.time = time; 
    }        
    
}
