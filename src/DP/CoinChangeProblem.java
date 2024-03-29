package DP;

import java.util.Arrays;

/*
Find minimum number of coins that make a given value

Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change? If it’s not possible to make a change, print -1.

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class CoinChangeProblem {

    public static void main(String[] args) {
        int value = 3;
        int[] arr = {2};
        int[] dp = new int[value + 1];
        Arrays.fill(dp, -1);
        //dp[0] = 0;

        int ans = minCoins(value, arr, dp);
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
        //System.out.println(minCoins(value, arr));
    }

    //using dynamic programming O(mn)
    static int minCoins(int value, int[] arr, int[] dp) {

        if(value == 0) {
            return 0;
        }

        if(dp[value] != -1) {
            return dp[value];
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(value - arr[i] >= 0) {
               int subAnswer = minCoins(value - arr[i], arr, dp);
               if(subAnswer != Integer.MAX_VALUE && subAnswer + 1 < ans) {
                    ans = subAnswer + 1;
                }
            }
        }
        dp[value] = ans;

        return ans;
    }

    //using Recursion - O(m^n)
    /*static int minCoins(int value, int[] arr) {

        if(value == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(value - arr[i] >= 0) {
                int subAnswer = minCoins(value - arr[i], arr);

                if(subAnswer + 1 < ans) {
                    ans = subAnswer + 1;
                }
            }
        }
        return ans;
    }*/
}
