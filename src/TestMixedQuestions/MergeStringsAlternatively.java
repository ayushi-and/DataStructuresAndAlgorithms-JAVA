package TestMixedQuestions;


/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

 */
class MergeStringsAlternatively {
    public static String mergeAlternately(String word1, String word2) {
        String result = "";
        //StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        while(n1 != 0 || n2 != 0) {
            if(n1 != 0) {
                result = result + word1.charAt(i);
                //sb.append(word1.charAt(i));
                n1--;
                i++;
            }
            if(n2 != 0) {
                result = result + word2.charAt(j);
                n2--;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcde", "pqr"));
    }
}