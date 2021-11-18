package TestMixedQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Using backtracking
//TC and SC: O(4^n * 3^m) OR (N*(4^N)): N number of digits in array
//n : number of digits containing 4 characters
//m : number of digits containing 3 characters
public class LetterCombinations {
    static List<String> findLetterCombinations(int[] arr) {
        int n = arr.length;
        List<String> result = new ArrayList<>();

        if(n == 0) {
            return result;
        }

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        backTrack(map, arr, 0, new StringBuilder(), result);
        return result;
    }

    static void backTrack(HashMap<Integer, String> map, int[] arr, int index, StringBuilder sb, List<String> result) {
        if(index == arr.length) {
            result.add(sb.toString());
            return;
        }
        String currentChar = map.get(arr[index]);
        for(int i = 0; i < currentChar.length(); i++) {
            sb.append(currentChar.charAt(i));
            backTrack(map, arr, index+1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //TC: O(n^2)
    static List<String> findLetterCombinations2(int[] arr) {
        int n = arr.length;
        LinkedList<String> result = new LinkedList<>();
        if(n == 0) {
            return result;
        }

        String[] str = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for(int i = 0; i < arr.length; i++) {
            while (result.peek().length() == i) {
                String element = result.poll();
                char[] charArray = str[arr[i]].toCharArray();
                for (char c : charArray) { //run 4 times max, so can take constant time
                    result.add(element + c);
                }
            }
        }
        return result;
    }


    //TC and SC: O(4^n)
    //Iterative using queue
    static List<String> findLetterCombinations3(int[] arr) {
        int n = arr.length;
        List<String> list = new ArrayList<>();

        if(n == 0) {
            return list;
        }

        String[] str = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while(!queue.isEmpty()) {
            String currentStr = queue.remove();

            if (currentStr.length() == n) {
                list.add(currentStr);
            } else {
                String val = str[arr[currentStr.length()]];
                for (int i = 0; i < val.length(); i++) {
                    queue.add(currentStr + val.charAt(i));
                }
            }
        }
        return list;
    }


    public static void main(String[] ar) {
        int[] arr = {2, 3};
        List<String> ans = findLetterCombinations(arr);
        System.out.println(ans);

        List<String> ans2 = findLetterCombinations2(arr);
        System.out.println(ans2);

        List<String> ans3 = findLetterCombinations3(arr);
        System.out.println(ans3);

        /*if(!ans.isEmpty()) {
            ans.forEach(str -> System.out.print(str + " "));
        }*/
    }

}
