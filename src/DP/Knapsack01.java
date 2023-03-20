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

    //Dynamic programming
    //Time Complexity: O(N * W). where ‘N’ is the number of elements and ‘W’ is capacity.
    //Auxiliary Space: O(N * W). The use of a 2-D array of size ‘N*W’.
    static int knapSack(int w, int[] wt, int[] val, int n) {
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

    //Recursion - O(2^n)
    /*static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return Math.max(val[n - 1]
                            + knapSack(W - wt[n - 1], wt,
                            val, n - 1),
                    knapSack(W, wt, val, n - 1));
    }*/



    //Using memoization
    //Time Complexity: O(N * W). As redundant calculations of states are avoided.
    //Auxiliary Space: O(N * W) + O(N). The use of a 2D array data structure for storing intermediate states and O(N) auxiliary stack space(ASS) has been used for recursion stack
    /*static int knapSackRec(int W, int wt[], int val[],
                           int n, int[][] dp)
    {

        // Base condition
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[n][W]
                = knapSackRec(W, wt, val, n - 1, dp);

        else

            // Return value of table after storing
            return dp[n][W]
                = max((val[n - 1]
                       + knapSackRec(W - wt[n - 1], wt, val,
                                     n - 1, dp)),
                      knapSackRec(W, wt, val, n - 1, dp));
    }

    static int knapSack(int W, int wt[], int val[], int N)
    {

        // Declare the table dynamically
        int dp[][] = new int[N + 1][W + 1];

        // Loop to initially filled the
        // table with -1
        for (int i = 0; i < N + 1; i++)
            for (int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        return knapSackRec(W, wt, val, N, dp);
    }

     */
}
