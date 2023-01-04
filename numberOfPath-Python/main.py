print("Uso del programa: NumberOfPaths.py [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check] [-t]\n\n" +
        "optional arguments:\n" +
        "    -d [DIRECTORY], --directory [DIRECTORY]     process many files in a directory\n" +
        "    -f [FILE], --file [FILE]                    process a single file\n" +
        "    -sm, --memoization                          count number of paths in a matrix with given cost to reach\n" +
        "                                                    (0, 0) cell through Memoization\n" +
        "    -st, --tabulation                           count number of paths in a matrix with given cost to reach\n" +
        "                                                    (0, 0) cell through Tabulation\n" +
        "    -check                                      check that the number of paths in a matrix with given cost\n" +
        "                                                    is the same through Tabulation and Memoization\n" +
        "    -t, --time                                  display execution time")

First_param = input("If you are going to use a file please enter F\n"+
                     "If you are going to use a directory please enter D\n"+
                     "Option: ")
Second_param = input("Please enter the route to the file or direcotry we are going to use:\n"+
                     "Route: ")
# Keyboard inputs