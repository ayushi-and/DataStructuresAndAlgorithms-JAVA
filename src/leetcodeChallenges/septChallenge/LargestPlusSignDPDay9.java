package leetcodeChallenges.septChallenge;

import java.util.Arrays;

/* ----Largest Plus Sign
You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines.
The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right,
and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.

Example 1:
Input: n = 5, mines = [[4,2]]
Output: 2
Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.

Example 2:
Input: n = 1, mines = [[0,0]]
Output: 0
Explanation: There is no plus sign, so return 0.

Constraints:
1 <= n <= 500
1 <= mines.length <= 5000
0 <= xi, yi < n
All the pairs (xi, yi) are unique.
https://www.youtube.com/watch?v=Hs72PdsJaRk
 */
//Optimized-DP: O(n^2) (since previously calculated value is already stored, so O(1))
public class LargestPlusSignDPDay9 {

    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int ans = 0;
        int[][] inputGrid = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(inputGrid[i], 1);
        }

        for(int[] mine : mines) {
            inputGrid[mine[0]][mine[1]] = 0;
        }

        //left and right values
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];

        for(int i = 0; i < n; i++) {
            left[i][0] = inputGrid[i][0];
            for(int j = 1; j < n; j++) {
                left[i][j] = inputGrid[i][j] == 1 ? left[i][j-1] + 1 : 0;
            }
            right[i][n-1] = inputGrid[i][n-1];
            for(int j = n-2; j >= 0; j--) {
                right[i][j] = inputGrid[i][j] == 1 ? right[i][j+1] + 1 : 0;
            }
        }

        //top and bottom values
        int[][] top = new int[n][n];
        int[][] bottom = new int[n][n];

        for(int j = 0; j < n; j++) {
            top[0][j] = inputGrid[0][j];
            for(int i = 1; i < n; i++) {
                top[i][j] = inputGrid[i][j] == 1 ? top[i-1][j] + 1 : 0;
            }
            bottom[n-1][j] = inputGrid[n-1][j];
            for(int i = n-2; i >= 0; i--) {
                bottom[i][j] = inputGrid[i][j] == 1 ? bottom[i+1][j] + 1 : 0;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, Math.min(Math.min(left[i][j], right[i][j]), Math.min(top[i][j], bottom[i][j])));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4, 2}};
        System.out.println(orderOfLargestPlusSign(n, mines));
    }
}
