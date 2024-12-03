import numpy as np

def perform_lup_decomposition(matrix):
    size = len(matrix)
    perm_matrix = np.eye(size)  
    lower_tri = np.zeros((size, size))  
    upper_tri = np.copy(matrix)  
    
    for col in range(size):
        max_val = 0
        pivot_row = col
        
        
        for row in range(col, size):
            if abs(upper_tri[row, col]) > max_val:
                max_val = abs(upper_tri[row, col])
                pivot_row = row
        
        if max_val == 0:
            raise ValueError("Matrix is singular")
        
        
        upper_tri[[col, pivot_row]] = upper_tri[[pivot_row, col]]
        
        lower_tri[[col, pivot_row]] = lower_tri[[pivot_row, col]]
        
        perm_matrix[[col, pivot_row]] = perm_matrix[[pivot_row, col]]
        
        for row in range(col + 1, size):
            
            lower_tri[row, col] = upper_tri[row, col] / upper_tri[col, col]
            
            
            upper_tri[row, col:] -= lower_tri[row, col] * upper_tri[col, col:]
    
    
    for i in range(size):
        lower_tri[i, i] = 1.0
    
    return perm_matrix, lower_tri, upper_tri


input_matrix = np.array([[4, 3, 2, 1],
                         [8, 7, 6, 5],
                         [4, 2, 1, 3],
                         [6, 5, 3, 2]], dtype=float)

perm, lower, upper = perform_lup_decomposition(input_matrix)
print("Original Matrix:")
print(input_matrix)
print("Permutation Matrix:")
print(perm)
print("Lower Triangular Matrix:")
print(lower)
print("Upper Triangular Matrix:")
print(upper)


permuted_matrix = np.dot(perm, input_matrix)
decomposed_matrix = np.dot(lower, upper)
print("Permuted Matrix:")
print(permuted_matrix)
print("Decomposed Matrix (LU):")
print(decomposed_matrix)
print("Are permuted matrix and LU decomposition equal?", np.allclose(permuted_matrix, decomposed_matrix))
