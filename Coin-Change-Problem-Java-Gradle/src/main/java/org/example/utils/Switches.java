package org.example.utils;

public class Switches {

    private Switches (){
        throw new IllegalStateException("Utility class");
    }

    public static void help(){
        System.out.println("usage: Coin-Change-Problem.jar [-h] [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check] [-t]\n\n" +
                "optional arguments:\n" +
                "    -h, --help                                  Show this help message and exit\n" +
                "    -d [DIRECTORY], --directory [DIRECTORY]     Process many files in a directory\n" +
                "    -f [FILE], --file [FILE]                    Process a single file\n" +
                "    -sm, --memoization                          Given an unlimited supply of coins of given denominations\n" +
                "                \"                                find the total number of distinct ways to get the desired change through Memoization\n" +
                "    -st, --tabulation                           Given an unlimited supply of coins of given denominations\n" +
                "                                                  find the total number of distinct ways to get the desired change through Tabulation\n" +
                "    -check                                      Given an unlimited supply of coins of given denominations\n" +
                "                                                  find the total number of distinct ways to get the desired change through Memoization and Tabulation\n");
        System.exit(0);
    }

    public static boolean contains(String[] argv, String arg1, String arg2) {
        for (String arg : argv) {
            if (arg.equals(arg1) || arg.equals(arg2)) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(String[] argv, String arg1, String arg2){
        for (int i = 0; i < argv.length; i++){
            if (arg1.equals(argv[i]) || arg2.equals(argv[i])) {
                return i;
            }
        }
        return 0;
    }
}

