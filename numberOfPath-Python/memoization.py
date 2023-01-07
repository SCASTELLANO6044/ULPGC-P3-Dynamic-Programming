
def find_number_of_paths_memoization(matrix, info):
    map = {"": 0}
    info.set_path(__count_paths(matrix, len(matrix)-1, len(matrix[0])-1, info.get_cost(), map))
    return info
def __count_paths(matrix, m, n, cost, map):
    if int(cost) < 0:
        return 0

    if int(m) == 0 and int(n) == 0:
        if int(matrix[0][0]) - int(cost) == 0:
            return 1
        else:
            return 0

    key = "("+str(m)+", "+str(n)+") - "+str(cost)

    if map.get(key) == None:
        if int(m) == 0:
            map[key] = __count_paths(matrix, 0, int(n)-1, int(cost)-int(matrix[m][n]), map)
        elif int(n) == 0:
            map[key] = __count_paths(matrix, int(m)-1, 0, int(cost)-int(matrix[m][n]), map)
        else:
            map[key] = __count_paths(matrix, int(m)-1, n, int(cost) - int(matrix[m][n]), map) + __count_paths(matrix, m, int(n)-1, int(cost)-int(matrix[m][n]), map)

    return map.get(key)