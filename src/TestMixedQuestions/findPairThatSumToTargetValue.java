package TestMixedQuestions;

import java.util.HashMap;
import java.util.Map;

public class findPairThatSumToTargetValue {

    static void sum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = sum - arr[i];
            if (map.containsKey(rem)) {
                System.out.println(arr[i] + " " +rem);
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,4,8,2,9};
        sum(arr, 11);
    }

}
