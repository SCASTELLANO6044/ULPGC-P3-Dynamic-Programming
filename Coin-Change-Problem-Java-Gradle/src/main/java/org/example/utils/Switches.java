package org.example.utils;

public class Switches {

    private Switches (){
        throw new IllegalStateException("Utility class");
    }

    public static void help(){
        System.out.println("usage: FMPSTSM.jar [-h] [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check] [-t]\n\n" +
                "optional arguments:\n" +
                "    -h, --help                                  Show this help message and exit\n" +
                "    -d [DIRECTORY], --directory [DIRECTORY]     Process many files in a directory\n" +
                "    -f [FILE], --file [FILE]                    Process a single file\n" +
                "    -sm, --memoization                          Find the minimum path sum in a triangle-shaped matrix\n" +
                "                                                   through Memoization\n" +
                "    -st, --tabulation                           Find the minimum path sum in a triangle-shaped matrix\n" +
                "                                                   through Tabulation\n" +
                "    -check                                      Check that the minimum path sum in a triangle-shaped matrix\n" +
                "                                                   is the same through Tabulation and Memoization\n");
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

