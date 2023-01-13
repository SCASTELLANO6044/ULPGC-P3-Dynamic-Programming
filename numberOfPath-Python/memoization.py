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

    info.set_path(__count_paths(int(len(matrix)) - 1, int(len(matrix[0])) - 1, int(info.get_cost())))
    __show_taken(dictionary)
    return info


def __show_taken(dictionary):
    path = []
    print("Los caminos tomados por el método de memoization son los correspondientes a las coordenadas que se " +
          "muestran a continuación: ")
    for i in dictionary:
        if dictionary.get(i) != 0:
            pointer = i.rfind(')')
            i = i[:-pointer + 1]
            i = i.rstrip()
            if i not in path:
                path.append(i)
    print(path)
    print("Teniendo siempre en cuenta que siempre avanzamos hacia la izquierda o hacia arriba descartando las " +
          "posibilidades de ir a casillas anteriores")
