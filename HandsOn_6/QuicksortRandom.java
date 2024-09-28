import java.util.Arrays;
import java.util.Random;

public class QuicksortRandom {

    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62, 32}; // Example array
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        quicksort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quicksort(arr, left, pivotIndex - 1); // Sort left partition
            quicksort(arr, pivotIndex + 1, right); // Sort right partition
        }
    }

    private static int partition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1); // Select random pivot
        int pivot = arr[pivotIndex];
        System.out.println("Selected Pivot: " + pivot + " from index " + pivotIndex); // Print the random pivot
        swap(arr, pivotIndex, right); // Move pivot to end

        int storeIndex = left; // Pointer for the smaller element
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right); // Move pivot to its final place
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
