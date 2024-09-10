
This is  HandOn Assignment

#### Name: Shalin Dhanani
#### Student ID :- 1002229452





# HandsOn-2


<details>


<summary>HandsOn-2/Correctness of Selection Sort</summary>

# Correctness of Selection sort

# Selection Sort


The algorithm finds the smallest element in the array first and exchanges it with the element in the first
position.Then it finds the second smallest element and exchanges it with the element in the second position and continues
in this way until the entire array is sorted.

* At the Start of each pass of outer loop:
      * the first **i** elements of the array **arr[0:i]** are in sorted order.
      * The other remaining **(n-i)** elements in **arr[i:n]**are greater or equal to all element in sorted portion.

## Initialization
* Before the first pass **i=0**;
* The loop invariant holds trivially since there are no elements in the sorted portion.so **arr[0:i]** is empty.

* Inductive Hypothesis: Assume the loop invariant holds at the start of iteration i. This means that **arr[0:i]** contains the smallest i elements of the array, sorted in ascending order, and all elements in **arr[i:n]** are greater than or equal to those in arr[0:i]. 

## Maintenance:

* In each pass, the minimum element from the unsorted portion **arr[i:n]** is selected and swapped with the element at index i.
* This ensures that the subarray **arr[0:i+1]**  is sorted and now contain the smallest **i+1** element of the array,sorted in ascending order
* Since the minimum element was swapped, the remaining **n-i-1** elements are still greater than or equal to the elements in the sorted part.

## Termination
* When i = n-1 the outer loop terminate
* At this point, loop variant guarantees that the  **arr[0:n]** is sorted  and last remaining element is greater than or equal to all previous element.
* So now element is in ascending order and sorted.

## Conclusion
Since the loop invariant is maintained before, during, and after the loop, and it repeats until the whole array is sorted, Selection Sort is correct.

</details>
<br>


# HandsOn-3

<details>

<summary>HandsOn-3 Assignment</summary>

[`HandsOn-3.md`](HandsOn_3/HandOn-3.md)
</details>