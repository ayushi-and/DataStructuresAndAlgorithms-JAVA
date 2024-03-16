package DP;

/*
Given a 2D array, find the maximum sum submatrix in it. For example, in the following 2D array, the maximum sum submatrix is highlighted with blue rectangle and sum of all elements in this submatrix is 29.

I/P { { 1, 2, -1, -4, -20 },
      { -8, -3, 4, 2, 1 },
      { 3, 8, 10, 1, 3 },
       -4, -1, 1, 7, -6 } }

O/P 29

This problem is mainly an extension of Largest Sum Contiguous Subarray for 1D array.
 */

import java.util.Arrays;

//Time Complexity: O(c*c*r), where c represents the number of columns and r represents the number of rows in the given matrix.
//Auxiliary Space: O(r), where r represents the number of rows in the given matrix.
public class MaximumSumRectangle {

    public static void main(String[] args) {

        int[][] arr = { { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 10, 1, 3 },
                {-4, -1, 1, 7, -6 } };

        int R = arr.length;
        int C = arr[0].length;

        System.out.println(maximumSumRectangle(R, C, arr));
    }
    public static int maximumSumRectangle(int R, int C, int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int[] sum = new int[R];

        for(int cStart = 0; cStart < C; cStart++) {
            Arrays.fill(sum, 0);
            for(int cEnd = cStart; cEnd < C; cEnd++) {
                for(int row = 0; row < R; row++) {
                    sum[row] += arr[row][cEnd];
                }
                int currentMaxSum = kadane(sum);
                maxSum = Math.max(maxSum, currentMaxSum);
            }
        }
        return maxSum;
    }

    public static int kadane(int[] arr) {
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(max_sum < sum) {
                max_sum = sum;
            }

            if(sum < 0) {
                sum = 0;
            }
        }

        return max_sum;
    }
}
