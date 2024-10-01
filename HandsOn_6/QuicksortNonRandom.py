import matplotlib.pyplot as plt

# Data for the benchmarks
sizes = [1000, 5000, 10000, 20000, 50000]
best_case_times = [256000, 73500, 127200, 386300, 635700]
worst_case_times = [160100, 123800, 195600, 438100, 914700]
average_case_times = [107400, 256200, 503400, 1056700, 3876600]

# Plotting the graph
plt.figure(figsize=(10, 6))
plt.plot(sizes, best_case_times, marker='o', label='Best Case (ns)', color='green')
plt.plot(sizes, worst_case_times, marker='o', label='Worst Case (ns)', color='red')
plt.plot(sizes, average_case_times, marker='o', label='Average Case (ns)', color='blue')

plt.title('Quicksort Benchmarking')
plt.xlabel('Array Size')
plt.ylabel('Time (nanoseconds)')
plt.xscale('log')  # Log scale for better visibility
plt.yscale('log')  # Log scale for better visibility
plt.xticks(sizes)
plt.legend()
plt.grid(True, which="both", ls="--", linewidth=0.5)
plt.tight_layout()

# Show the plot
plt.show()
