import numpy as np
import time
import matplotlib.pyplot as plt

def lup_decomposition(A):
    n = len(A)
    P = np.eye(n)  
    L = np.zeros((n, n))  
    U = np.copy(A)  
    
    for k in range(n):
        p = 0
        k_prime = k
        
        
        for i in range(k, n):
            if abs(U[i, k]) > p:
                p = abs(U[i, k])
                k_prime = i
        
        if p == 0:
            raise ValueError("Singular matrix")
        
        
        U[[k, k_prime]] = U[[k_prime, k]]
        
        
        L[[k, k_prime]] = L[[k_prime, k]]
        
        
        P[[k, k_prime]] = P[[k_prime, k]]
        
        for i in range(k + 1, n):
            
            L[i, k] = U[i, k] / U[k, k]
            
            
            U[i, k:] -= L[i, k] * U[k, k:]
    
    
    for i in range(n):
        L[i, i] = 1.0
    
    return P, L, U


sizes = [10, 50, 100, 500, 1000]


num_iterations = 10


best_times = {}
average_times = {}
worst_times = {}


for size in sizes:
    
    best_times[size] = []
    average_times[size] = []
    worst_times[size] = []
    
    for _ in range(num_iterations):
        
        A = np.random.rand(size, size)
        
        
        start_time = time.time()
        P, L, U = lup_decomposition(A)
        end_time = time.time()
        exec_time = end_time - start_time
        
        
        best_times[size].append(exec_time)
        average_times[size].append(exec_time)
        worst_times[size].append(exec_time)


for size in sizes:
    best_times[size] = min(best_times[size])
    average_times[size] = sum(average_times[size]) / num_iterations
    worst_times[size] = max(worst_times[size])


plt.plot(sizes, list(best_times.values()), label=f'Best Case: O(n^3)', marker='o')
plt.plot(sizes, list(average_times.values()), label=f'Average Case: O(n^3)', marker='s')
plt.plot(sizes, list(worst_times.values()), label=f'Worst Case: O(n^3)', marker='^')


plt.title('LUP Decomposition Complexity Analysis')
plt.xlabel('Matrix Size')
plt.ylabel('Execution Time (seconds)')
plt.legend()
plt.grid(True)
plt.show()