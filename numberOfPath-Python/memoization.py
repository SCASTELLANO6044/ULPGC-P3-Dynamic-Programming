def find_number_of_paths_memoization(matrix, info):
    dictionary = {}
    info.set_path(__count_paths(matrix, len(matrix) - 1, len(matrix[0]) - 1, info.get_cost(), dictionary))
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

    return info


def __count_paths(matrix, m, n, cost, dictionary):
    if int(cost) < 0:
        return 0

    if int(m) == 0 and int(n) == 0:
        if int(matrix[0][0]) - int(cost) == 0:
            return 1
        else:
            return 0

    key = "(" + str(m) + ", " + str(n) + ") - " + str(cost)

    if dictionary.get(key) is None:
        if int(m) == 0:
            dictionary[key] = __count_paths(matrix, 0, int(n) - 1, int(cost) - int(matrix[m][n]), dictionary)
        elif int(n) == 0:
            dictionary[key] = __count_paths(matrix, int(m) - 1, 0, int(cost) - int(matrix[m][n]), dictionary)
        else:
            dictionary[key] = __count_paths(matrix, int(m) - 1, n, int(cost) - int(matrix[m][n]),
                                            dictionary) + __count_paths(matrix, m, int(n) - 1,
                                                                        int(cost) - int(matrix[m][n]), dictionary)
    return dictionary.get(key)
