import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            System.out.print("Enter the size of array :- ");
            int num = in.nextInt();
            int[] unsorted_arr = new int[num];
            for (int i = 0; i < unsorted_arr.length; i++) {
                unsorted_arr[i] = in.nextInt();
            }


            bubblesort(unsorted_arr);

            System.out.println("Sorted array:");
            for (int i = 0; i < unsorted_arr.length; i++) {
                System.out.print(unsorted_arr[i] + " ");
            }
        }


    public static void bubblesort(int[] A){
        int flag =1;
         for (int i =0;i<A.length-1;i++){
             for (int j=0;j<A.length-i-1;j++){
                 if (A[j] > A[j + 1]) {

                     // Swap arr[j] and arr[j+1]
                    int temp = A[j];
                     A[j] = A[j + 1];
                     A[j + 1] = temp;
                      flag = 0;
                 }
             }
             if (flag==1){
                 break;
             }
         }


    }
}
