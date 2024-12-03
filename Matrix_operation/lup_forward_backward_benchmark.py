import numpy as np
import time
import matplotlib.pyplot as plt

def lup_solve(L, U, b):
    n = len(L)
    x = np.zeros(n)

    
    y = np.zeros(n)
    for i in range(n):
        y[i] = b[i]
        for j in range(i):
            y[i] -= L[i, j] * y[j]

    
    for i in range(n - 1, -1, -1):
        x[i] = y[i]
        for j in range(i + 1, n):
            x[i] -= U[i, j] * x[j]
        x[i] /= U[i, i]

    return x

def benchmark_lup_solve(matrix_sizes):
    execution_times = []
    for size in matrix_sizes:
        L = np.random.rand(size, size)
        U = np.random.rand(size, size)
        b = np.random.rand(size)
        
        start_time = time.time()
        x = lup_solve(L, U, b)
        end_time = time.time()
        
        execution_times.append(end_time - start_time)
    return execution_times


def worst_case(n):
    return n**2


def best_case(n):
    return n


def average_case(n):
    return n*np.log(n)  

matrix_sizes = [100, 200, 300, 400, 500, 800, 1000, 1400]


execution_times = benchmark_lup_solve(matrix_sizes)


for size, time_taken in zip(matrix_sizes, execution_times):
    print(f"Matrix size {size}x{size}: Execution time = {time_taken:.6f} seconds")


plt.figure(figsize=(12, 6))


plt.subplot(1, 2, 1)
plt.plot(matrix_sizes, execution_times, marker='o')
plt.title('LUP Solve Execution Time vs Matrix Size')
plt.xlabel('Matrix Size')
plt.ylabel('Execution Time (seconds)')
plt.grid(True)


matrix_sizes_up_to_500 = np.arange(10, 501, 10)
worst_case_times_up_to_500 = [worst_case(n) for n in matrix_sizes_up_to_500]
best_case_times_up_to_500 = [best_case(n) for n in matrix_sizes_up_to_500]
average_case_times_up_to_500 = [average_case(n) for n in matrix_sizes_up_to_500]

plt.subplot(1, 2, 2)
plt.plot(matrix_sizes_up_to_500, worst_case_times_up_to_500,label='Worst Case (O(n^2))', linestyle='--')
plt.plot(matrix_sizes_up_to_500, best_case_times_up_to_500, label='Best Case (O(n))', linestyle='--')
plt.plot(matrix_sizes_up_to_500, average_case_times_up_to_500, label='Average Case (O(n log n))', linestyle='--')
plt.title('Time Complexities (Matrix Sizes up to 500)')
plt.xlabel('Matrix Size (n)')
plt.ylabel('Execution Time ')
plt.legend()
plt.grid(True)

plt.tight_layout()
plt.show()