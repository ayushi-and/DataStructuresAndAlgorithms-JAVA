package TestMixedQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 I  : [ 8,1,2,2,3]
O :  [4,0,1,1,3 ]

 */
public class CountSmallerElementsOfEachElementInArray {

    public static int[] print(int[] arr) {
        //int[] nums = new int[arr.length];

        int[] nums = Arrays.copyOf(arr,arr.length);

        Arrays.sort(nums); // 1,2,2,3,8
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        int[] result = new int[arr.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            int count = 0;
            int j = 0;
            while(j < i) { //1,2,2,3,8
                if(nums[j] < nums[i]) {
                    count++;
                }
                j++;
            }
            elementCountMap.put(nums[i], count);
        }

        for(int i = 0; i < arr.length; i++) {
            result[i] = elementCountMap.getOrDefault(arr[i], 0);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 4, 4, 4};
        int[] res = print(arr);

        for(int val: res) {
            System.out.print(val + " ");
        }
    }
}
