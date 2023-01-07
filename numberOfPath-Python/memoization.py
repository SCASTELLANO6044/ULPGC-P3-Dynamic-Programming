import data
def find_number_of_paths_memoization(matrix, info):
    info.set_path(__count_paths(matrix, len(matrix)-1, len(matrix[0])-1, info.get_cost()))

def __count_paths(matrix, m, n, cost):
    if cost < 0:
        return 0

    if m == 0 and n == 0:
        if matrix[0][0] - cost == 0:
            return 1
        else:
            return 0
