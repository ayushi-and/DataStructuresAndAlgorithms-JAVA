package leetcodeChallenges.septChallenge;

/*---Longest Turbulent Subarray
Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.

Example 1:
Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

Example 2:
Input: arr = [4,8,12,16]
Output: 2

Example 3:
Input: arr = [100]
Output: 1

Constraints:
1 <= arr.length <= 4 * 104
0 <= arr[i] <= 109
 */
public class LongestTurbulentSubArrayDay15 {
    public static int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int max = 1;
        int start = 0;
        int end = 0;

        while (start < A.length - 1) {
            if (A[start] == A[start+1]) {
                start++;
                continue;
            }
            end = start+1;
            while (end+1 < A.length && isTurbulent(A, end)) {
                end++;
            }

            System.out.println(start + " "+end);
            max = Math.max(max, end-start+1);
            start = end;
        }
        return max;
    }

    private static boolean isTurbulent(int[] A, int k) {
        return (A[k] > A[k-1] && A[k] > A[k+1]) || (A[k] < A[k-1]) && (A[k] < A[k+1]);
    }

    public static void main(String[] args) {
        int[] arr1 = {9,4,2,10,7,8,8,1,9};
        int[] arr2 = {4,8,12,16};
        int[] arr3 = {100};

        System.out.println(maxTurbulenceSize(arr1));
        System.out.println(maxTurbulenceSize(arr2));
        System.out.println(maxTurbulenceSize(arr3));
    }
}
