package DP;

import java.util.Arrays;

/*
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence (strict) is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {1,0, 1, 3, 2};
        int n = arr.length;

        System.out.println(getLength(arr, n));

    }

    public static int getLength(int[] arr, int n) {

        int[] nums = new int[n];
        int count = 0;

        Arrays.fill(nums, 1);


        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && nums[i] < nums[j] + 1) {
                    nums[i] = nums[j] + 1;

                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(count < nums[i]) {
                count = nums[i];
            }
        }

        return count;
    }
}
