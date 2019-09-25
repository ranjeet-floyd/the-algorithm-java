package com.practise.divideconquer;

import java.util.Arrays;

import org.javatuples.Triplet;

/**
 * Run => mvn exec:java
 * -Dexec.mainClass="com.practise.divideconquer.MaxSubArray" <br/>
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
        int expectedOutput = 41;
        System.out.println("Input Array: " + Arrays.toString(arr));
        DivideNConquer divideNConquer = new DivideNConquer();
        Triplet<Integer, Integer, Integer> triplet = divideNConquer.findMaxSubArray(arr, 0, arr.length - 1);
        assert expectedOutput != triplet.getValue0() : "Result is not Correct | Expected " + expectedOutput
                + " and Actual result : " + triplet.getValue0();
        System.out.println("Result Max Sub Array " + triplet);
    }

    public static class DivideNConquer {
        /**
         * Solution of max sub-Array using Divide and conquer. Idea is to divide arr in
         * two parts. ...</br>
         * (1)left array => low => to => mid </br>
         * (2)right array => mid => to => high </br>
         * (3)cross array => low => to => high <br/>
         * Max Sub array can be found either in left, right or in between left-right
         * (cross array). </br>
         * Max sub array will be Max of ( left-sum, right-sum , cross-array-sum ) </br>
         */

        /**
         * Divide array in sub array and find max-sum for each sub-arrays.
         * 
         * @param arr  input array.
         * @param low  low index.
         * @param high high index.
         * @return Triplet<max-sum, low, high>
         */
        public Triplet<Integer, Integer, Integer> findMaxSubArray(int[] arr, int low, int high) {

            System.out.println("low: " + low + " high:" + high);
            if (low == high) {
                return Triplet.with(arr[low], low, high);
            }
            int mid = (low + high) / 2;

            // left array
            Triplet<Integer, Integer, Integer> leftTriplet = findMaxSubArray(arr, low, mid);

            // right array
            Triplet<Integer, Integer, Integer> rightTriplet = findMaxSubArray(arr, mid + 1, high);

            // cross array
            Triplet<Integer, Integer, Integer> crossTriplet = findMaxCrossingSubArray(arr, low, mid, high);

            // compare of left, right and cross arrays sum

            // left sub-array has max sub array
            if (leftTriplet.getValue0() > rightTriplet.getValue0()
                    && leftTriplet.getValue0() > crossTriplet.getValue0()) {
                return leftTriplet;
            }

            // righ sub-array has max sub array
            if (rightTriplet.getValue0() > crossTriplet.getValue0()) {
                return rightTriplet;
            }

            // cross sub-array has max sub array
            return crossTriplet;

        }

        //
        private Triplet<Integer, Integer, Integer> findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
            // left array .. mid to low
            int leftSum = 0;
            int leftMaxSum = arr[mid];
            int leftMaxSumIndex = mid;
            for (int i = mid; i >= 0; i--) {
                leftSum = leftSum + arr[i];
                if (leftMaxSum < leftSum) {
                    leftMaxSum = leftSum;
                    leftMaxSumIndex = i;
                }
            }

            // right array .. mid to high
            int rightSum = 0;
            int rightMaxSum = arr[mid + 1];
            int rightMaxSumIndex = mid + 1;
            for (int j = mid + 1; j <= high; j++) {
                rightSum = rightSum + arr[j];
                if (rightMaxSum < rightSum) {
                    rightMaxSum = rightSum;
                    rightMaxSumIndex = j;
                }
            }
            return Triplet.with(leftMaxSum + rightMaxSum, leftMaxSumIndex, rightMaxSumIndex);

        }
    }

}