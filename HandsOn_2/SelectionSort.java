import java.util.Scanner;

public class SelectionSort {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            System.out.println("Enter the size of array");
            int num = in.nextInt();
            int[] unsorted_arr = new int[num];
            for (int i = 0; i < unsorted_arr.length; i++) {
                unsorted_arr[i] = in.nextInt();
            }


            selectionSort(unsorted_arr);

            System.out.println("Sorted array:");
            for (int i = 0; i < unsorted_arr.length; i++) {
                System.out.print(unsorted_arr[i] + " ");
            }
        }

        public static void selectionSort(int[] A) {
            int n = A.length;

            // Traverse the array
            for (int i = 0; i < n - 1; i++) {
                // Find the minimum element in the unsorted portion of the array
                int min_i = i;
                int minx = A[i];

                for (int j = i + 1; j < n; j++) {
                    if (A[j] < minx) {
                        min_i = j;
                        minx = A[j];
                    }
                }

                // Swap the found minimum element with the first element of the unsorted portion
                A[min_i] = A[i];
                A[i] = minx;
            }
        }
    }


