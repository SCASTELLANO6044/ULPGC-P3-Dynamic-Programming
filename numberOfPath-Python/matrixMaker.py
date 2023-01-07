import data, utilities
def create_matrix(file_name, info):
    with open(file_name, 'r') as file:
        lines = file.readlines()
    matrix = utilities.format_matrix(lines)
    info.set_rows(matrix[0][0])
    info.set_cols(matrix[0][1])
    info.set_cost(matrix[0][2])
    matrix_val = matrix[1:]
    return matrix_val

