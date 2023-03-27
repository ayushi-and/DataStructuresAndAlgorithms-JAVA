package DP;

public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

       longestCommonSubsequence(text1, text2);

    }

    public static void longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];

        lcs(n1, n2, text1, text2, dp);
    }

    //Time Complexity: O(m*n)
    //Auxiliary Space: O(m*n)
    public static void lcs(int n1, int n2, String str1, String str2, int[][] dp) {

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int longestLength = dp[n1][n2];
        int length = longestLength;

        char[] subsequenceArr = new char[longestLength];

        int i = n1;
        int j = n2;

        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                subsequenceArr[longestLength - 1] = str1.charAt(i-1);
                i--;
                j--;
                longestLength--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }

        for(int p = 0; p < length; p++) {
            System.out.print(subsequenceArr[p]);
        }

    }


}
