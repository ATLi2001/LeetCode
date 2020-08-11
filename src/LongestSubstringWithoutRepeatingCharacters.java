import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(String s) {
        // use sliding window technique

        char[] chars = s.toCharArray();
        int maxLen = 0;

        // the characters that have been seen in the current substring
        HashSet<Character> sub = new HashSet<>();
        // index of where current substring starts
        int start = 0;
        for(int i = 0; i < chars.length; i++){
            if(!sub.contains(chars[i])) {
                sub.add(chars[i]);
            }
            // encountered repeat character
            else{
                // update maxLen
                maxLen = Math.max(maxLen, sub.size());
                // slide window forward
                while(sub.contains(chars[i])) {
                    sub.remove(chars[start]);
                    start++;
                }
                sub.add(chars[i]);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // expected 3
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // expected 1
        System.out.println(lengthOfLongestSubstring("aaaaa"));
        // expected 3
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
