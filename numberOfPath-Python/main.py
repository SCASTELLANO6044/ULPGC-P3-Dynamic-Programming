tab = False
mem = False
both = False
isDirectory = False

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
                     "Opción: ")
if First_param == 'd' or 'D':
    isDirectory = True
    second_param = input("Por favor introduce la ruta al directorio:\n"+
                         "Ruta: ")
elif First_param == 'f' or 'F':
    second_param = input("Por favor introduce la ruta al archivo:\n" +
                         "Ruta: ")
Third_param = input("Por favor, introduzca alguna de las siguientes opciones:\n"+
                    "sm -> para contar el número de caminos mediante memoization,\n"+
                    "st -> para contar el número de caminos mediante tabulation, o,\n"+
                    "check -> para contar el número de caminos por ambos métodos.\n"+
                    "Opción: ")

# Keyboard inputs