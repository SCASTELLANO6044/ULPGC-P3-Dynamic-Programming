import data, utilities
def create_matrix(file_name):
    with open(file_name, 'r') as file:
        lines = file.readlines()
    matrix = utilities.format_matrix(lines)
    data.setRows(matrix[0][0])
    data.setCols(matrix[0][1])
    data.setCost(matrix[0][2])
    matrix_val = matrix[1:]
    return matrix_val

