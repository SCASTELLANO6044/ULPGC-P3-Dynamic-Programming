def create_matrix(file_name, info):
    with open(file_name, 'r') as file:
        lines = file.readlines()
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
