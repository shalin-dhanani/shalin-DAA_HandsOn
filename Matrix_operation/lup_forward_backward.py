import numpy as np

def solve_lu(lower, upper, rhs):
    size = len(lower)
    intermediate = np.zeros(size)
    solution = np.zeros(size)

    
    for row in range(size):
        intermediate[row] = rhs[row]
        for col in range(row):
            intermediate[row] -= lower[row, col] * intermediate[col]

    
    for row in range(size - 1, -1, -1):
        solution[row] = intermediate[row]
        for col in range(row + 1, size):
            solution[row] -= upper[row, col] * solution[col]
        solution[row] /= upper[row, row]

    return solution, intermediate


lower_triangular = np.array([[1, 0, 0],
                              [0.5, 1, 0],
                              [0.2, 0.4, 1]])

upper_triangular = np.array([[10, 2, 1],
                              [0, 4, 3],
                              [0, 0, 5]])

rhs_vector = np.array([15, 10, 5])


final_solution, intermediate_solution = solve_lu(lower_triangular, upper_triangular, rhs_vector)
print("Final Solution (x):", final_solution)
print("Intermediate Solution (y):", intermediate_solution)
