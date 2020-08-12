import java.util.HashMap;

public class MinimumWindowSubstring {

    // Given a string S and a string T, find the minimum window in S
    // which will contain all the characters in T in complexity O(n).
    private static String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";

        // map of characters and their occurrence in t
        HashMap<Character, Integer> tMap = new HashMap<>();
        // what has yet to be matched in t
        HashMap<Character, Integer> unmatched = new HashMap<>();
        // potential repeated characters that are matched
        HashMap<Character, Integer> repeat = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            // first appearance
            if(!tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), 1);
                unmatched.put(t.charAt(i), 1);
            }
            else {
                tMap.replace(t.charAt(i), tMap.get(t.charAt(i)) + 1);
                unmatched.replace(t.charAt(i), unmatched.get(t.charAt(i)) + 1);
            }
        }

        // start and end of the minWindow substring
        int subStart = -1;
        int subEnd = s.length();

        int left = 0;
        // initialize left and right
        while(left < s.length() && !tMap.containsKey(s.charAt(left)))
            left++;
        int right = left;

        while(right < s.length()){
            // character match
            if(unmatched.containsKey(s.charAt(right))){
                // edit unmatched
                if(unmatched.get(s.charAt(right)) == 1)
                    unmatched.remove(s.charAt(right));
                else
                    unmatched.replace(s.charAt(right), unmatched.get(s.charAt(right)) - 1);
            }
            // not unmatched but in tMap
            else if(tMap.containsKey(s.charAt(right)) && unmatched.size() != 0){
                if(!repeat.containsKey(s.charAt(right)))
                    repeat.put(s.charAt(right), 1);
                else
                    repeat.replace(s.charAt(right), repeat.get(s.charAt(right)) + 1);
            }

            // see if a minWindow has been found
            if(unmatched.size() == 0){
                int oldLen = subEnd - subStart;
                int newLen = right - left;

                if(newLen < oldLen) {
                    subStart = left;
                    subEnd = right;
                }
                // move left so the character at left could be unmatched
                if(!repeat.containsKey(s.charAt(left)))
                    unmatched.put(s.charAt(left), 1);
                // if there was a repeat in the middle, don't want to move right
                else{
                    right--;
                    if(repeat.get(s.charAt(left)) == 1)
                        repeat.remove(s.charAt(left));
                    else
                        repeat.replace(s.charAt(left), repeat.get(s.charAt(left)) - 1);
                }
                left++;
                while(!tMap.containsKey(s.charAt(left)))
                    left++;
            }
            right++;
        }

        if(subStart == -1)
            return "";
        return s.substring(subStart, subEnd + 1);
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        // expected BANC
        System.out.println(minWindow(S, "ABC"));
        // expected ""
        System.out.println(minWindow(S, "XYZ"));

    }
}
