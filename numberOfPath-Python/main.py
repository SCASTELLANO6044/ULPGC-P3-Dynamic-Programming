import copy, os, time, sys

# Clase info
class Info:
    def __init__(self):
        self.time = None
        self.path = None
        self.cost = None
        self.cols = None
        self.rows = None

    def __int__(self):
        self.rows = 0
        self.cols = 0
        self.cost = 0
        self.path = 0
        self.time = ""

    def get_rows(self):
        return self.rows

    def get_cols(self):
        return self.cols

    def get_cost(self):
        return int(self.cost)

    def get_path(self):
        return self.path

    def get_time(self):
        return self.time

    def set_rows(self, value):
        self.rows = value

    def set_cols(self, value):
        self.cols = value

    def set_cost(self, value):
        self.cost = value

    def set_path(self, value):
        self.path = value

    def set_time(self, value):
        self.time = value

# Matrix Maker
def create_matrix(file_name, info):
    with open(file_name, 'r') as FILE:
        lines = FILE.readlines()
    matrix = __format_matrix(lines)
    info.set_rows(matrix[0][0])
    info.set_cols(matrix[0][1])
    info.set_cost(matrix[0][2])
    matrix_val = matrix[1:]
    return matrix_val


def __format_matrix(lines):
    result = []
    for x in lines:
        result.append(x.split())
    return result

# Memoization

def find_number_of_paths_memoization(matrix, info):
    dictionary = {}

    def __count_paths(m, n, cost):
        if cost < 0:
            return 0

        if m == 0 and n == 0:
            if int(matrix[0][0]) - cost == 0:
                return 1
            else:
                return 0

        key = "(" + str(m) + ", " + str(n) + ") - " + str(cost)

        if dictionary.get(key) is None:
            if m == 0:
                dictionary[key] = __count_paths(0, n - 1, cost - int(matrix[m][n]))
            elif n == 0:
                dictionary[key] = __count_paths(m - 1, 0, cost - int(matrix[m][n]))
            else:
                dictionary[key] = __count_paths(m - 1, n, cost - int(matrix[m][n])) + __count_paths(
                    m, n - 1,
                       cost - int(matrix[m][n]))
        return dictionary.get(key)

    info.set_path(__count_paths(len(matrix) - 1, len(matrix[0]) - 1, info.get_cost()))
    __show_taken(dictionary)
    return info


def __show_taken(dictionary):
    camino = []
    print("Los caminos tomados por el método de memoization son los correspondientes a las coordenadas que se " +
          "muestran a continuación: ")
    for i in dictionary:
        if dictionary.get(i) != 0:
            pointer = i.rfind(')')
            i = i[:-pointer + 1]
            i = i.rstrip()
            if i not in camino:
                camino.append(i)
    print(camino)
    print("Teniendo siempre en cuenta que siempre avanzamos hacia la izquierda o hacia arriba descartando las " +
          "posibilidades de ir a casillas anteriores")

# Tabulation

def find_number_of_paths_tabulation(matrix, info):
    given_cost = info.get_cost()
    rows = len(matrix)
    cols = len(matrix[0])

    tabulation_table = [[[0 for i in range(int(given_cost) + 1)] for j in range(cols)] for k in range(rows)]

    if int(matrix[0][0]) > int(given_cost):
        info.set_path(0)

    tabulation_table[0][0][int(matrix[0][0])] = 1

    current_cost = 0
    for i in range(rows):
        current_cost += int(matrix[i][0])
        if current_cost <= int(given_cost):
            tabulation_table[i][0][current_cost] = 1

    current_cost = 0
    for i in range(cols):
        current_cost += int(matrix[0][i])
        if current_cost <= int(given_cost):
            tabulation_table[0][i][current_cost] = 1

    for i in range(1, rows):
        for j in range(1, cols):
            for k in range(int(given_cost) + 1):
                if k - int(matrix[i][j]) >= 0:
                    tabulation_table[i][j][k] = tabulation_table[i - 1][j][k - int(matrix[i][j])] + tabulation_table[i][j - 1][k - int(matrix[i][j])]

    info.set_path(tabulation_table[rows - 1][cols - 1][int(given_cost)])

    return info


# Inicio del programa.

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
        information = Info()
        matrix = create_matrix(file_name, information)

        if both:
            tab_matrix = copy.deepcopy(matrix)
            mem_matrix = copy.deepcopy(matrix)

            info_paths = find_number_of_paths_tabulation(tab_matrix, information)
            print("Número de caminos por tabulation: " + str(info_paths.get_path()))

            print("\n" + "*************************************************************************" + "\n")

            info_paths = find_number_of_paths_memoization(mem_matrix, information)
            print("Numero de caminos por memoization: " + str(info_paths.get_path()))

        elif tab:
            tab_matrix = copy.deepcopy(matrix)
            info_paths = find_number_of_paths_tabulation(tab_matrix, information)
            print("Número de caminos por tabulation: " + str(info_paths.get_path()))

        elif mem:
            mem_matrix = copy.deepcopy(matrix)
            info_paths = find_number_of_paths_memoization(mem_matrix, information)
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
