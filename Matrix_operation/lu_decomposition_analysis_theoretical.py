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

def worst_case(n):
    return n**3

def best_case(n):
    return n**2

def average_case(n):
    return n**2.3  


matrix_sizes = [100, 200, 300, 400, 500, 800, 1000, 1400]


execution_times = benchmark_lu_decomposition(matrix_sizes)


worst_case_times = [worst_case(n) for n in matrix_sizes]
best_case_times = [best_case(n) for n in matrix_sizes]
average_case_times = [average_case(n) for n in matrix_sizes]


plt.figure(figsize=(10, 6))


plt.plot(matrix_sizes, worst_case_times, label='Worst Case (O(n^3))', linestyle='--')
plt.plot(matrix_sizes, best_case_times, label='Best Case (O(n^2))', linestyle='--')
plt.plot(matrix_sizes, average_case_times, label='Average Case (O(n^3))', linestyle='--')

plt.title('LU Decomposition Execution Time vs Matrix Size')
plt.xlabel('Matrix Size')
plt.ylabel('Execution Time (seconds)')
plt.legend()
plt.grid(True)
plt.show()