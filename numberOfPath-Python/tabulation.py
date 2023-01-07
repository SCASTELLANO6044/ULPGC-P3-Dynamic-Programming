def find_number_of_paths_tabulation(matrix, info):
    given_cost = info.get_cost()
    rows = len(matrix)
    cols = len(matrix[0])

    print(type(given_cost))
    print(type(rows))
    print(type(cols))

    tab = [[[0 for i in range(int(given_cost)+1)]for j in range(cols)] for k in range(rows)]
    print(tab)
