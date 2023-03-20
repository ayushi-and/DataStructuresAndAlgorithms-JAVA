package DP;

//0-1 knapsack
//https://medium.com/@fabianterh/how-to-solve-the-knapsack-problem-with-dynamic-programming-eb88c706d3cf

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        int w = 10;
        int n = 4;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};

        System.out.println(knapSack(w, wt, val, n));
    }

    static int knapSack(int w, int[] wt, int[] val, int n)
    {
        // your code here
        int[][] mat = new int[n + 1][w + 1];

        for(int i = 0; i < w+1; i++) {
            mat[0][i] = 0;
        }

        for(int j = 0; j < n+1; j++) {
            mat[j][0] = 0;
        }

        for(int item = 1; item <= n; item++) {
            for(int capacity = 1; capacity <= w; capacity++) {

                int maxValueExcludingCurrent = mat[item - 1][capacity]; // This is guaranteed to exist
                int maxValueIncludingCurrent = 0; // initialize this value to 0
                int weightOfCurr = wt[item - 1]; // We use item -1 to account for the extra row at the top
                if(weightOfCurr <= capacity) { // We check if the knapsack can fit the current item

                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
                    maxValueIncludingCurrent = val[item - 1] + mat[item - 1][remainingCapacity]; // If so, maxValWithCurr is at least the value of the current item added to the remainingCapacity
                }

                mat[item][capacity] = Math.max(maxValueExcludingCurrent, maxValueIncludingCurrent); // Pick the larger of the two
            }
        }

        System.out.println(Arrays.deepToString(mat)); // Visualization of the table
        return mat[n][w];
    }
}
