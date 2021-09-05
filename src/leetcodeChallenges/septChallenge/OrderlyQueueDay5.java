package leetcodeChallenges.septChallenge;

import java.util.Arrays;

/*
---Orderly Queue
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.
Example 1:
Input: s = "cba", k = 1
Output: "acb"
Explanation:
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".

Example 2:
Input: s = "baaca", k = 3
Output: "aaabc"
Explanation:
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".

Constraints:
1 <= k <= s.length <= 1000
s consist of lowercase English letters.
*/
public class OrderlyQueueDay5 {
    static String orderlyQueue(String str, int k) {
        if(k > 1) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }

        String result = str;
        for(int i = 1; i < str.length(); i++) {
            String temp = str.substring(i) + str.substring(0, i);

            if(result.compareTo(temp) > 0) {
                result = temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1));
        System.out.println(orderlyQueue("baaca", 2));
    }
}
