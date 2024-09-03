
This HandOn Assignment

I have uploaded code for bubblesort,insertionsort,selectionsort and graph of (timetaken vs number of element)

I have uploaded pdf file for arguing the correctness of selectionSort 

# Correctness of Selection sort

# Selection Sort


The algorithm finds the smallest element in the array first and exchanges it with the element in the first
position.Then it finds the second smallest element and exchanges it with the element in the second position and continues
in this way until the entire array is sorted.

* At the Start of each pass of outer loop:
      * the first i elements of the array are in sorted order.
      * The other remaining (n-i) elements are greater or equal to all element in sorted portion.

## Initialization
* Before the first pass i=0;
* The loop invariant holds trivially since there are no elements in the sorted portion.

## Maintenance:

* In each pass, the minimum element from the unsorted portion is selected and swapped with the element at index i.
* This ensures that the first i+1 elements are in sorted.
* Since the minimum element was swapped, the remaining n-i-1 elements are still greater than or equal to the elements in the sorted part.

## Termination
* When i = n-1 the outer loop terminate
* Till this pass, loop variant guarantees that the first n-1 element are in ascending order  and last remaining element is greater than or equal to all previous element.
* So now element is in ascending order and sorted.

## Conclusion
Since the loop invariant is maintained before, during, and after the loop, and it repeats until the whole array is sorted, Selection Sort is correct.