import java.util.Arrays;
import java.util.Random;

public class QuicksortNonRandom {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000, 50000}; // Array sizes for testing
        benchmark(sizes);
    }

    private static void benchmark(int[] sizes) {
        System.out.printf("%-10s %-20s %-20s %-20s%n", "Size", "Best Case (ns)", "Worst Case (ns)", "Average Case (ns)");

        for (int n : sizes) {
            int[] bestCase = generateBestCase(n);
            int[] worstCase = generateWorstCase(n);
            int[] averageCase = generateAverageCase(n);

            // Measure Best Case
            long bestStart = System.nanoTime();
            quicksort(bestCase, 0, bestCase.length - 1);
            long bestEnd = System.nanoTime();
            long bestTime = bestEnd - bestStart;

            // Measure Worst Case
            long worstStart = System.nanoTime();
            quicksort(worstCase, 0, worstCase.length - 1);
            long worstEnd = System.nanoTime();
            long worstTime = worstEnd - worstStart;

            // Measure Average Case
            long avgStart = System.nanoTime();
            quicksort(averageCase, 0, averageCase.length - 1);
            long avgEnd = System.nanoTime();
            long avgTime = avgEnd - avgStart;

            // Display the benchmark results
            System.out.printf("%-10d %-20d %-20d %-20d%n", n, bestTime, worstTime, avgTime);
        }
    }

    private static int[] generateBestCase(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i; // Sorted in ascending order
        }
        return arr;
    }

    private static int[] generateWorstCase(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i; // Sorted in descending order
        }
        return arr;
    }

    private static int[] generateAverageCase(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n); // Random values between 0 and n-1
        }
        return arr;
    }

    public static void quicksort(int[] arr, int left, int right) {
        while (left < right) {
            int pivotIndex = partition(arr, left, right);
            quicksort(arr, left, pivotIndex - 1); // Sort left partition
            left = pivotIndex + 1; // Sort right partition
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = left + (right - left) / 2; // Use the middle element as pivot
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, left); // Move pivot to start
        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, left, i - 1); // Move pivot to its correct place
        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


