package com.practise.divideconquer;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
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

        void findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {

        }

        void findMaxSubArray(int[] arr, int low, int high) {

        }
    }

}