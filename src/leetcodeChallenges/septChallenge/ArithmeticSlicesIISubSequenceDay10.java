package leetcodeChallenges.septChallenge;

import java.util.HashMap;

/* ----Arithmetic Slices II - Subsequence
Given an integer array nums, return the number of all the arithmetic subsequences of nums.
A sequence of numbers is called arithmetic if it consists of at least three elements and
if the difference between any two consecutive elements is the same.
For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
The test cases are generated so that the answer fits in 32-bit integer.

Example 1:
Input: nums = [2,4,6,8,10]
Output: 7
Explanation: All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]

Example 2:
Input: nums = [7,7,7,7,7]
Output: 16
Explanation: Any subsequence of this array is arithmetic.

Constraints:
1  <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
https://www.youtube.com/watch?v=XjLT4TaXsgw
 */
public class ArithmeticSlicesIISubSequenceDay10 {
    public static int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[nums.length];

        for(int i = 0; i < nums.length; i++) {
            maps[i] = new HashMap<>(); //initialize map for every index of array, map will contain common difference and
                                        //count of AP's(containing greater than or equal to two elements) ending on that value of index.
        }

        for(int i = 1; i < maps.length; i++) {
            for(int j = 0; j < i; j++) {
                long commonDifference = (long)nums[i] - (long)nums[j]; //Take long since one corner case i.e. -128, 127 (cd = 256 which is out of range), so take long instead of integer
                if(commonDifference <= Integer.MIN_VALUE || commonDifference >= Integer.MAX_VALUE) {
                    continue;
                }
                int apsEndingOnJ = maps[j].getOrDefault((int)commonDifference, 0);
                int apsEndingOnI = maps[i].getOrDefault((int)commonDifference, 0);

                ans += apsEndingOnJ;

                maps[i].put((int)commonDifference, apsEndingOnI + apsEndingOnJ + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10};
        int[] arr2 = {7, 7, 7, 7, 7};

        System.out.println(numberOfArithmeticSlices(arr1));
        System.out.println(numberOfArithmeticSlices(arr2));

    }
}
