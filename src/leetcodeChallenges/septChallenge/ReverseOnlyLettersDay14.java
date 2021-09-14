package leetcodeChallenges.septChallenge;

/*-----Reverse Only Letters
Given a string s, reverse the string according to the following rules:
All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:
Input: s = "ab-cd"
Output: "dc-ba"

Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

Constraints:
1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
 */
public class ReverseOnlyLettersDay14 {
    public static String reverseOnlyLetters(String s) {
        int low = 0;
        int high = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        while (low < high) {
            if (!Character.isAlphabetic(sb.charAt(low))) {
                low++;
                continue;
            }
            if (!Character.isAlphabetic(sb.charAt(high))) {
                high--;
                continue;
            }
            char temp = sb.charAt(low);
            sb.setCharAt(low, sb.charAt(high));
            sb.setCharAt(high, temp);
            low++;
            high--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
