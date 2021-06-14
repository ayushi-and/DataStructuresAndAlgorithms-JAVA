package TestMixedQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//find the longest substring of unique letters using Java.
//For example, the longest substring of unique letters in “CODINGISAWESOME” is “NGISAWE”.
//Brute force
//Time Complexity: O(n*n)
/*
public class LongestSubstringWithNoRepeatingChars {

    static String getUniqueCharacterSubstringBruteForce(String input){
        String output = "";
        for (int start = 0; start < input.length(); start++) {
            Set<Character> visited = new HashSet<>();
            int end = start;
            for (; end < input.length(); end++) {
                char currChar = input.charAt(end);
                if (visited.contains(currChar)) {
                    break;
                } else {
                    visited.add(currChar);
                }
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end);
            }
        }
        return output;
    }
    public static void main (String[] args)
    {
        System.out.println(getUniqueCharacterSubstringBruteForce("CODINGISAWESOME"));
    }
}
*/



//Optimized solution: Sliding window pattern
//Time Complexity: linear O(n)
/*public class LongestSubstringWithNoRepeatingChars {

    static String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

    public static void main (String[] args)
    {
        System.out.println(getUniqueCharacterSubstring("CODINGISAWESOME"));
    }
}*/

//Optimized solution 2nd: Sliding Window
public class LongestSubstringWithNoRepeatingChars {

    static Integer getUniqueCharacterSubstring(String input) {
        int maxLength = 0; // Maximum length of substring
        String output = ""; // Longest Substring With No Repeating Chars
        HashSet<Character> uniqueCharacters = new HashSet<>(); // This set will store the unique characters
        int start = 0; // Starting window index
        int end = 0; // Ending window index

        if (input == null || input.equals("")) {
            return 0;
        }

        while(end < input.length()){
            if(uniqueCharacters.add(input.charAt(end))){
                end++;
                maxLength = Math.max(maxLength, uniqueCharacters.size());
                if(output.length() < end - start + 1) {
                    output = input.substring(start, end);
                }
            }
            else{
                uniqueCharacters.remove(input.charAt(start));
                start++;
            }
        }
        System.out.println("Longest Substring With No Repeating Chars is " +output);
        return maxLength;
    }

    public static void main (String[] args)
    {
        System.out.println(getUniqueCharacterSubstring("CODINGISAWESOME"));
    }
}




