class Problem_2 {

    
    static int removeDuplicates(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[uniqueIndex]) {
                uniqueIndex++;
                array[uniqueIndex] = array[i];
            }
        }

        return uniqueIndex + 1; 
    }

    public static void main(String[] args) {
        int[] array1 = {2, 2, 2, 2, 2};
        int[] array2 = {1, 2, 2, 3, 4, 4, 4, 5, 5};

        
        int newSize1 = removeDuplicates(array1);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newSize1; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        
        int newSize2 = removeDuplicates(array2);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newSize2; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.println();
    }
}
