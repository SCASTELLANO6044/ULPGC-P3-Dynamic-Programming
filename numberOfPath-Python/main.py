import matrixMaker, copy, data, memoization, tabulation, os, time, sys

tab = False
mem = False
both = False
isDirectory = False

valid_first = ["-d", "--directory", "-f", "--file", "-h", "--help"]
valid_second = ["-sm", "--memoization", "-st", "--tabulation", "--check"]

if sys.argv[1] == "-h" or sys.argv[1] == "--help":
    print("Uso del programa: NumberOfPaths.py [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check] [-t]\n\n" +
          "optional arguments:\n" +
          "    -d [DIRECTORY], --directory [DIRECTORY]     process many files in a directory\n" +
          "    -f [FILE], --file [FILE]                    process a single file\n" +
          "    -sm, --memoization                          count number of paths in a matrix with given cost to reach\n" +
          "                                                    (0, 0) cell through Memoization\n" +
          "    -st, --tabulation                           count number of paths in a matrix with given cost to reach\n" +
          "                                                    (0, 0) cell through Tabulation\n" +
          "    --check                                      check that the number of paths in a matrix with given cost\n" +
          "                                                    is the same through Tabulation and Memoization\n")

elif sys.argv[1] not in valid_first or sys.argv[3] not in valid_second:
    print("No ha escrito los parámetros de entrada del programa correctamente:\n"
          "Uso del programa: NumberOfPaths.py [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check] [-t]\n\n" +
          "optional arguments:\n" +
          "    -d [DIRECTORY], --directory [DIRECTORY]     process many files in a directory\n" +
          "    -f [FILE], --file [FILE]                    process a single file\n" +
          "    -sm, --memoization                          count number of paths in a matrix with given cost to reach\n" +
          "                                                    (0, 0) cell through Memoization\n" +
          "    -st, --tabulation                           count number of paths in a matrix with given cost to reach\n" +
          "                                                    (0, 0) cell through Tabulation\n" +
          "    --check                                      check that the number of paths in a matrix with given cost\n" +
          "                                                    is the same through Tabulation and Memoization\n")
else:
    second_param = ""

    if sys.argv[1] == valid_first[0] or sys.argv[1] == valid_first[1]:
        isDirectory = True
        second_param = sys.argv[2]
        print(second_param)
    elif sys.argv[1] == valid_first[2] or sys.argv[1] == valid_first[3]:
        second_param = sys.argv[2]

    if sys.argv[3] == valid_second[4]:
        tab = False
        mem = False
        both = True
    elif sys.argv[3] == valid_second[0] or sys.argv[3] == valid_second[1]:
        tab = False
        mem = True
        both = False
    elif sys.argv[3] == valid_second[2] or sys.argv[3] == valid_second[3]:
        tab = True
        mem = False
        both = False


    def __search_paths_for_file(file_name):
        t = time.process_time()
        info = data.Info()
        matrix = matrixMaker.create_matrix(file_name, info)

        if both:
            tab_matrix = copy.deepcopy(matrix)
            mem_matrix = copy.deepcopy(matrix)

            info_paths = tabulation.find_number_of_paths_tabulation(tab_matrix, info)
            print("Número de caminos por tabulation: " + str(info_paths.get_path()))

            print("\n" + "*************************************************************************" + "\n")

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
        print("\n" + "------------------------------------------------------------------------" + "\n")


    if isDirectory:
        files = []
        for path in os.listdir(second_param):
            if os.path.isfile(os.path.join(second_param, path)):
                files.append(path)
        for file in files:
            __search_paths_for_file(second_param + file)
    else:
        __search_paths_for_file(second_param)

    input("Press enter to exit;")
