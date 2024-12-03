import numpy as np
import time
import matplotlib.pyplot as plt

def lu_decomposition(A):
    n = A.shape[0]
    L = np.eye(n)  
    U = np.zeros((n, n))  
    
    for k in range(n):
        U[k, k:] = A[k, k:] - L[k, :k] @ U[:k, k:]  
        L[(k+1):, k] = (A[(k+1):, k] - L[(k+1):, :] @ U[:, k]) / U[k, k]  
    
    return L, U

def benchmark_lu_decomposition(matrix_sizes):
    execution_times = []
    for size in matrix_sizes:
        A = np.random.rand(size, size)
        
        start_time = time.time()
        L, U = lu_decomposition(A)
        end_time = time.time()
        
        execution_times.append(end_time - start_time)
    return execution_times


matrix_sizes = [100, 200, 300, 400, 500, 800, 1000, 1400]


execution_times = benchmark_lu_decomposition(matrix_sizes)


plt.plot(matrix_sizes, execution_times, marker='o')
plt.title('LU Decomposition Execution Time vs Matrix Size')
plt.xlabel('Matrix Size')
plt.ylabel('Execution Time (seconds)')
plt.grid(True)
plt.show()