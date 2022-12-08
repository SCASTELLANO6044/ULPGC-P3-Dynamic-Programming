package com.mycompany.numberofpaths;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class NumberOfPaths {

    public static void main(String[] args) throws Exception {
        
        // Muestra el mensaje de ayuda si se emplea el argumento "-h" o "--help"
        if (Switches.contains(args, "-h", "--help")) Switches.help();
        
        /*
         * boolean tab: cierto si el método a emplear es Tabulation
         * boolean mem: cierto si el método a emplear es Memoization
         * boolean both: cierto si se desea emplear ambos métodos
        */
        
        boolean tab = false;
        boolean mem = false;
        boolean both = false;
        
        if (Arrays.stream(args).anyMatch("-check"::equals )) {
            tab = false; 
            mem = false; 
            both = true; 
        } else if (Switches.contains(args, "-sm", "--memoization")) { 
            tab = false;
            mem = true; 
            both = false;
        } else if (Switches.contains(args, "-st", "--tabulation" )) { 
            tab = true;
            mem = false;
            both = false; 
        }

        /**
         * boolean isDirectory: cierto si uno de los argumentos es un directorio
         * String path: ruta del directorio o fichero indicado en los argumentos pasados
        */
        boolean isDirectory = false; 
        String path = "";

        /**
         * Se indica que es un directorio y se almacena el nombre del directorio
         * en la variable "path"
        */
        if (Switches.contains(args, "-d", "--directory")) {
            isDirectory = true; 
            path = args[Switches.indexOf(args, "-d", "--directory") + 1];

        // Se indica que es un fichero y se almacena el nombre del fichero en la variable "path"
        } else if (Switches.contains(args, "-f", "--file")) {
            path = args[Switches.indexOf(args, "-f", "--file") + 1];
        }

        if (isDirectory) {
            // Se ordenan todos los ficheros del directorio alfanuméricamente
            File f = new File(path);
            String[] files = f.list();
            Comparator<String> numericalOrder = AlphanumericSortComparator.NUMERICAL_ORDER;
            Arrays.sort(files, numericalOrder);

            // Se lee todos los ficheros del directorio y almacenamos los datos en matrices
            for (String file : files) {
                int[][] matrix = MatrixMaker.createMatrix(path + "/" + file);
                
                if (both) { // -check
                    int[][] tabulationMatrix  = MatrixMaker.deepCopy(matrix);
                    int[][] memoizationMatrix = MatrixMaker.deepCopy(matrix);

                    Tabulation.findNumberOfPathsTabulation(tabulationMatrix, Data.getCost());
                    int tabulationPaths = Data.getPaths();

                    Memoization.findNumberOfPathsMemoization(memoizationMatrix, Data.getCost());
                    int memoizationPaths = Data.getPaths();

                    if (tabulationPaths == memoizationPaths) { 
                        System.out.print("Check: Both number of paths are equal | " + path + "/" + file + " | " + tabulationPaths + " paths found \t"); 
                        
                        /**
                         * En caso de que una de las opciones pasadas sean "-t" o "--time" 
                         * se muestra el tiempo transcurrido en el cálculo del número de rutas
                        */
                        Switches.displayTime(args);
                    } else System.out.print("Check: Both number of paths are different \t");
                } else if (tab) { // -st
                    int[][] tabulationMatrix = MatrixMaker.deepCopy(matrix);
                    Tabulation.findNumberOfPathsTabulation(tabulationMatrix, Data.getCost());
                    int tabulationPaths = Data.getPaths();
                    
                    System.out.print("Tabulation:   " + path + "/" + file + " | " + tabulationPaths + " paths found \t");
                    Switches.displayTime(args);
                } else if (mem) { // -sm
                    int[][] memoizationMatrix = MatrixMaker.deepCopy(matrix);
                    Memoization.findNumberOfPathsMemoization(memoizationMatrix, Data.getCost());
                    int memoizationPaths = Data.getPaths();
                    
                    System.out.print("Memoization:  " + path + "/" + file + " | " + memoizationPaths + " paths found \t");
                    Switches.displayTime(args);
                }
            }
        } else { // En este caso trataremos con un fichero en vez de con un directorio
            int[][] matrix = MatrixMaker.createMatrix(path);
   
            if (both) { // -check
                int[][] tabulationMatrix  = MatrixMaker.deepCopy(matrix);
                int[][] memoizationMatrix = MatrixMaker.deepCopy(matrix);

                Tabulation.findNumberOfPathsTabulation(tabulationMatrix, Data.getCost());
                int tabulationPaths = Data.getPaths();

                Memoization.findNumberOfPathsMemoization(memoizationMatrix, Data.getCost());
                int memoizationPaths = Data.getPaths();

                if (tabulationPaths == memoizationPaths){ 
                    System.out.print("Check: Both number of paths are equal | " + path + " | " +  tabulationPaths + " paths found \t");
                    Switches.displayTime(args); 
                } else System.out.print("Check: Both number of paths are different \t");
            } else if (tab) { // -st
                int[][] tabulationMatrix = MatrixMaker.deepCopy(matrix);
                Tabulation.findNumberOfPathsTabulation(tabulationMatrix, Data.getCost());
                int tabulationPaths = Data.getPaths();
                
                System.out.print("Tabulation:   " + path + " | " +  tabulationPaths + " paths found \t");
                Switches.displayTime(args);
            } else if (mem) { // -sm
                int[][] memoizationMatrix = MatrixMaker.deepCopy(matrix);
                Memoization.findNumberOfPathsMemoization(memoizationMatrix, Data.getCost());
                int memoizationPaths = Data.getPaths();
                
                System.out.print("Memoization:  " + path + " | " +  memoizationPaths + " paths found \t");
                Switches.displayTime(args);
            }
        }        
    }
}
