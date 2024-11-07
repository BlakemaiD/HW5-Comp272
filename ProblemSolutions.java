/******************************************************************
 *
 *   Blake / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        //create a hash table
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int i = 0; i < list1.length; i++) {
            table.put(list1[i], list1[i]);
        }

        for (int k = 0; k < list2.length; k++) {
            if (!table.contains(list2[k])) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        //idea is to turn the array into a max heap, then pulling the kth term form the top
        // create a priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i<array.length; i++){
            maxHeap.add(array[i]);
        }
        int kth = 0;
        for (int i = 0; i < k; i++) { //will make the kth largest one be the last
            kth = maxHeap.poll();
        }
        return kth;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        //create a combined array by making an array with the length
        int[] newArray = new int[array1.length +array2.length];

        //add the previous arrays to the new array
        for (int i = 0; i < array1.length; i++) {
            newArray[i] = array1[i];
        }

        for (int k = 0; k < array2.length; k++) {
            newArray[array1.length + k] = array2[k];
        }

        Arrays.sort(newArray);
        return newArray;
    }

}
