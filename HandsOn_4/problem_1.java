class Problem_1 {

    // Merge two sorted arrays
    static void mergeTwoArrays(int[] first, int[] second, int firstSize, int secondSize, int[] merged) {
        int index1 = 0, index2 = 0, mergedIndex = 0;

        while (index1 < firstSize && index2 < secondSize) {
            if (first[index1] < second[index2]) {
                merged[mergedIndex++] = first[index1++];
            } else {
                merged[mergedIndex++] = second[index2++];
            }
        }

        while (index1 < firstSize) {
            merged[mergedIndex++] = first[index1++];
        }

        while (index2 < secondSize) {
            merged[mergedIndex++] = second[index2++];
        }
    }

    // Print array
    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Merge K sorted arrays
    static void mergeKSortedArrays(int[][] arrays, int start, int end, int[] result) {
        if (start == end) {
            System.arraycopy(arrays[start], 0, result, 0, arrays[start].length);
            return;
        }

        if (end - start == 1) {
            mergeTwoArrays(arrays[start], arrays[end], arrays[start].length, arrays[end].length, result);
            return;
        }

        int mid = (start + end) / 2;

        int leftSize = (mid - start + 1) * arrays[0].length;
        int rightSize = (end - mid) * arrays[0].length;

        int[] leftMerged = new int[leftSize];
        int[] rightMerged = new int[rightSize];

        mergeKSortedArrays(arrays, start, mid, leftMerged);
        mergeKSortedArrays(arrays, mid + 1, end, rightMerged);

        mergeTwoArrays(leftMerged, rightMerged, leftMerged.length, rightMerged.length, result);
    }

    public static void main(String[] args) {
        // Example 1
        int[][] arrays1 = {
            {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}
        };

        int numArrays1 = arrays1.length;
        int[] mergedArray1 = new int[numArrays1 * arrays1[0].length];

        mergeKSortedArrays(arrays1, 0, numArrays1 - 1, mergedArray1);

        System.out.println("Merged array (Example 1):");
        printArray(mergedArray1);

        // Example 2
        int[][] arrays2 = {
            {1, 3, 7},
            {2, 4, 8},
            {9, 10, 11}
        };

        int numArrays2 = arrays2.length;
        int[] mergedArray2 = new int[numArrays2 * arrays2[0].length];

        mergeKSortedArrays(arrays2, 0, numArrays2 - 1, mergedArray2);

        System.out.println("Merged array (Example 2):");
        printArray(mergedArray2);
    }
}
