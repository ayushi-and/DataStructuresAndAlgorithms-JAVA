package leetcodeChallenges.septChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*--Intersection of Two Arrays II
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
//Solved using sorting : Two Pointer Approach: TC: O(mlogm + nlogn)
public class IntersectionOfTwoArraysUsing2PointerDay17 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
            }
        }

        //list to array conversion
        int[] result = new int[list.size()];
        for(int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] result = intersect(nums1, nums2);

        for(int i = 0; i < result.length; i++) {
            System.out.print(" " +result[i]);
        }
    }
}
