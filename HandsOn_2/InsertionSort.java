import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of array :- ");
        int num = in.nextInt();
        int[] unsorted_arr = new int[num];
        for (int i = 0; i < unsorted_arr.length; i++) {
            unsorted_arr[i] = in.nextInt();
        }


        insertionSort(unsorted_arr);

        System.out.println("Sorted array:");
        for (int i = 0; i < unsorted_arr.length; i++) {
            System.out.print(unsorted_arr[i] + " ");
        }
    }
    public static void insertionSort(int[] A){
        for (int i = 2 ;i< A.length;i++){
            int key = A[i];
            int j = i-1;

            while (j>=0 && A[j] > key){
                A[j+1] = A[j];
                j = j-1;

            }
            A[j+1] = key;
        }
    }
}
