import numpy as np

def decompose_lu(matrix):
    size = len(matrix)
    lower_tri = np.eye(size)  
    upper_tri = np.copy(matrix)  
    for col in range(size):
        for row in range(col + 1, size):
            multiplier = upper_tri[row, col] / upper_tri[col, col]  
            lower_tri[row, col] = multiplier  
            upper_tri[row, col:] -= multiplier * upper_tri[col, col:]  
    
    return lower_tri, upper_tri

example_matrix = np.array([[1, 2, 3, 4],
                           [5, 6, 7, 8],
                           [9, 10, 11, 12],
                           [13, 14, 15, 16]], dtype=float)

lower, upper = decompose_lu(example_matrix)
print("Lower Triangular Matrix (L):")
print(lower)
print("Upper Triangular Matrix (U):")
print(upper)
