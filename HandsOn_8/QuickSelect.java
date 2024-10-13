import java.util.Scanner;
import java.util.Arrays;

public class QuickSelect {

    
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        
        return i;
    }
    
    
    public int quickSelect(int[] arr, int low, int high, int i) {
        if (low == high) {
            return arr[low];
        }
        
        int pivotIndex = partition(arr, low, high);
        int k = pivotIndex - low + 1;
        
        if (i == k) {
            return arr[pivotIndex];
        } else if (i < k) {
            return quickSelect(arr, low, pivotIndex - 1, i);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, i - k);
        }
    }
    
    
    public void printArray(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
    }
    
    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        Scanner scanner = new Scanner(System.in);
        
       
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        
        
        qs.printArray(arr);
        
        
        System.out.print("Enter the ith element you want to find (1 <= i <= " + arr.length + "): ");
        int i = scanner.nextInt();
        
        
        if (i < 1 || i > arr.length) {
            System.out.println("Invalid input. Please enter a number between 1 and " + arr.length + ".");
        } else {
            System.out.println("The " + i + "th smallest element is " + qs.quickSelect(arr, 0, arr.length - 1, i));
        }
        
        scanner.close();
    }
}
