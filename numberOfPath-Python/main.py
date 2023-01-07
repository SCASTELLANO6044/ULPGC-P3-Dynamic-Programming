import matrixMaker, copy, data, memoization, tabulation, os, time

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
      "                                                    is the same through Tabulation and Memoization\n")

First_param = input("If you are going to use a file please enter f\n" +
                    "If you are going to use a directory please enter d\n" +
                    "Opción: ")

second_param = ""

if First_param == "d":
    isDirectory = True
    second_param = input("Por favor introduce la ruta al directorio:\n" +
                         "Ruta: ")
elif First_param == "f":
    second_param = input("Por favor introduce la ruta al archivo:\n" +
                         "Ruta: ")

Third_param = input("Por favor, introduzca alguna de las siguientes opciones:\n" +
                    "sm -> para contar el número de caminos mediante memoization,\n" +
                    "st -> para contar el número de caminos mediante tabulation, o,\n" +
                    "check -> para contar el número de caminos por ambos métodos.\n" +
                    "Opción: ")

if Third_param == 'check':
    tab = False
    mem = False
    both = True
elif Third_param == 'sm':
    tab = False
    mem = True
    both = False
elif Third_param == 'st':
    tab = True
    mem = False
    both = False


def __search_paths_for_file(file_name):
    t = time.process_time()

    print("Archivo: " + file_name)
    info = data.Info()
    matrix = matrixMaker.create_matrix(file_name, info)

    if both:
        tab_matrix = copy.deepcopy(matrix)
        mem_matrix = copy.deepcopy(matrix)

        info_paths = tabulation.find_number_of_paths_tabulation(tab_matrix, info)
        print("Número de caminos por tabulation: " + str(info_paths.get_path()))

        info_paths = memoization.find_number_of_paths_memoization(mem_matrix, info)
        print("Numero de caminos por memoization: " + str(info_paths.get_path()))
    elif tab:
        tab_matrix = copy.deepcopy(matrix)
        info_paths = tabulation.find_number_of_paths_tabulation(tab_matrix, info)
        print("Número de caminos por tabulation: " + str(info_paths.get_path()))

    elif mem:
        mem_matrix = copy.deepcopy(matrix)
        info_paths = memoization.find_number_of_paths_memoization(mem_matrix, info)
        print("Numero de caminos por memoization: " + str(info_paths.get_path()))

    ftime = time.process_time() - t
    print("Tiempo: " + str(ftime))


if isDirectory:
    files = []
    for path in os.listdir(second_param):
        if os.path.isfile(os.path.join(second_param, path)):
            files.append(path)
    for file in files:
        __search_paths_for_file(second_param + file)
else:
    __search_paths_for_file(second_param)
