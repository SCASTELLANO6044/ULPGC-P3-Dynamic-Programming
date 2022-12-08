package com.mycompany.numberofpaths;

public class Switches {
    
    /**
     * Método que se encarga de mostrar la ayuda por pantalla
    */
    public static void help(){
        System.out.println("usage: NumberOfPaths.jar [-h] [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check] [-t]\n\n" +
        "optional arguments:\n" +
        "    -h, --help                                  show this help message and exit\n" +
        "    -d [DIRECTORY], --directory [DIRECTORY]     process many files in a directory\n" +
        "    -f [FILE], --file [FILE]                    process a single file\n" +
        "    -sm, --memoization                          count number of paths in a matrix with given cost to reach\n" +
        "                                                    (0, 0) cell through Memoization\n" +
        "    -st, --tabulation                           count number of paths in a matrix with given cost to reach\n" +
        "                                                    (0, 0) cell through Tabulation\n" +
        "    -check                                      check that the number of paths in a matrix with given cost\n" +
        "                                                    is the same through Tabulation and Memoization\n" +
        "    -t, --time                                  display execution time");
        System.exit(0);
    }

    /**
     * @param argv - Argumentos recibidos desde la terminal
     * @param arg1 - Cadena de texto a comparar
     * @param arg2 - Cadena de texto a comparar
     * @return Verdadero en función de si la comparación es verdadera. 
     *         Falso en caso contrario
    */
    public static boolean contains(String[] argv, String arg1, String arg2) {
        for (String arg : argv) {
            if (arg.equals(arg1) || arg.equals(arg2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param argv - Argumentos recibidos desde la terminal
     * @param arg1 - Cadena de texto a comparar
     * @param arg2 - Cadena de texto a comparar
     * @return Índice donde se encuentre el argumento a comparar
    */
    public static int indexOf(String[] argv, String arg1, String arg2){
        for (int i = 0; i < argv.length; i++){
            if (arg1.equals(argv[i]) || arg2.equals(argv[i])) {
                return i;
            }
        }
        return 0;
    }
    
    /**
     * @param args - Argumentos recibidos desde la terminal
    */    
    public static void displayTime(String[] args) {
        if (Switches.contains(args, "-t", "--time")) System.out.println(Data.getTime() + "s.\t");
    }    
}
