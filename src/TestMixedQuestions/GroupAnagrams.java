package TestMixedQuestions;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {


    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    //O(n*k)
    /*public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }*/

    //O(n * k*logk)
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> stringAndAnagramsMap = new HashMap<>();

        for(String str : strs) { //n
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr); //k*logk
            String key = new String(charArr);

            List<String> anagramsList = stringAndAnagramsMap.getOrDefault(key,new ArrayList<>());
            anagramsList.add(str);

            stringAndAnagramsMap.put(key, anagramsList);
        }

        for(Map.Entry<String, List<String>> entry: stringAndAnagramsMap.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
