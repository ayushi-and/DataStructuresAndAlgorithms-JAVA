package DP;

/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */
public class MinimumEditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minOperations(word1, word2));
    }

    public static int minOperations(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int i = 0; i < n1; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j < n2; j++) {
            dp[0][j] = j;
        }

        return minOperation(word1, word2, n1, n2, dp);

    }

    static int minOperation(String word1, String word2, int n1, int n2, int[][] dp) {

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[n1][n2];
    }
}
