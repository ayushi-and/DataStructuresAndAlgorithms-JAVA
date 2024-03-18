package Graph;

import java.util.*;

/*
Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.


Example 1:

Input:
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is
'b', 'd', 'a', 'c' Note that words are sorted
and in the given language "baa" comes before
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input:
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.


Your Task:
You don't need to read or print anything. Your task is to complete the function findOrder() which takes  the string array dict[], its size N and the integer K as input parameter and returns a string denoting the order of characters in the alien language.


Expected Time Complexity: O(N * |S| + K) , where |S| denotes maximum length.
Expected Space Compelxity: O(K)


Constraints:
1 ≤ N, M ≤ 300
1 ≤ K ≤ 26
1 ≤ Length of words ≤ 50
 */

//Expected Time Complexity: O(N * |S| + K) , where |S| denotes maximum length.
//Expected Space Compelxity: O(K)
class AlienDictionaryTopoSort
{
    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        List<List<Integer>> adjList = new ArrayList<>(K);
        int[] inDegree = new int[K];
        Arrays.fill(inDegree, 0);
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < K; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < dict.length-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int n = Math.min(s1.length(), s2.length());
            int p = 0;
            
            while(p < n) {
                if(s1.charAt(p) != s2.charAt(p)) {
                    adjList.get(s1.charAt(p)-'a').add(s2.charAt(p)-'a');
                    break;
                }
                p++;
                
            }
        }
        
        
        for(List<Integer> list: adjList) {
            for(Integer ele: list) {
                inDegree[ele]++;
            }
        }
        
        for(int i = 0; i < K; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        
        while(!queue.isEmpty()) {
            int element = queue.remove();
            //System.out.println((char)(element+'a'));
            sb.append((char)(element+'a'));
            for(int ele : adjList.get(element)) {
                if(--inDegree[ele] == 0) {
                    queue.add(ele);
                }
            }
            
        }
        
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        int N = 5;
        int K = 4;
        String[] dict = new String[] {"baa","abcd","abca","cab","cad"};

        String str = findOrder(dict, N, K);
        System.out.println(str);

    }
}