package TestMixedQuestions;

//Given a string S. The task is to print all permutations of a given string.
//Input: ABC
//Output:
//ABC ACB BAC BCA CAB CBA
//Explanation:
//Given string ABC has permutations in 6
//forms as ABC, ACB, BAC, BCA, CAB and CBA .

import java.util.Scanner;

//TC: O(n*n!)
public class PermutationsOfString {

    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n-1);
    }

}

//Second approach
/*
public class PermutationsOfString {

    static void permute(String s , String answer)
    {
        if (s.length() == 0)
        {
            System.out.print(answer + "  ");
            return;
        }

        for(int i = 0 ;i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }

    // Driver code
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        String s;
        String answer="";

        System.out.print("Enter the string : ");
        s = scan.next();

        System.out.print("\nAll possible strings are : ");
        permute(s, answer);
    }
}
}
*/

//GFG submission without maintaining order lexicographically
/*
class Solution {
    static List<String> res = new ArrayList<>();
    public List<String> find_permutation(String S) {
        // Code here

        int l = 0;
        int r = S.length() - 1;
        permute(S, l, r);
        return res;
    }

    public static void permute(String str, int l, int r) {

        if(l == r){
            res.add(str);
        }
        else{
        for(int i = l; i <= r; i++){
            str = swap(str, l, i);
            permute(str, l+1, r);
            str = swap(str, l, i);
        }
    }
}

    public static String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
 */