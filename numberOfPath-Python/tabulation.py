def find_number_of_paths_tabulation(matrix, info):
    given_cost = info.get_cost()
    rows = len(matrix)
    cols = len(matrix[0])

    tab = [[[0 for i in range(int(given_cost) + 1)] for j in range(cols)] for k in range(rows)]

    if int(matrix[0][0]) > int(given_cost):
        info.set_path(0)

    tab[0][0][int(matrix[0][0])] = 1

    current_cost = 0
    for i in range(rows):
        current_cost += int(matrix[i][0])
        if current_cost <= int(given_cost):
            tab[i][0][current_cost] = 1

    current_cost = 0
    for i in range(cols):
        current_cost += int(matrix[0][i])
        if current_cost <= int(given_cost):
            tab[0][i][current_cost] = 1

    for i in range(1, rows):
        for j in range(1, cols):
            for k in range(int(given_cost) + 1):
                if k - int(matrix[i][j]) >= 0:
                    tab[i][j][k] = tab[i - 1][j][k - int(matrix[i][j])] + tab[i][j - 1][k - int(matrix[i][j])]

    info.set_path(tab[rows - 1][cols - 1][int(given_cost)])

    return info
