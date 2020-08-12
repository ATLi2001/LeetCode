import java.util.HashMap;

public class WordPattern {

    // Given a pattern and a string str, find if str follows the same pattern.
    // Here follow means a full match, such that there is a bijection
    // between a letter in pattern and a non-empty word in str
    private static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");

        if(pattern.length() != words.length)
            return false;

        // key is a char in pattern, value is string in word
        HashMap<Character, String> charToString = new HashMap<>();
        // reverse map
        HashMap<String, Character> stringToChar = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String s = words[i];

            // first appearance
            if(!charToString.containsKey(c)){
                // make sure string version doesn't have
                if(stringToChar.containsKey(s))
                    return false;
                else {
                    charToString.put(c, s);
                    stringToChar.put(s, c);
                }
            }
            // make sure value is same as before
            else{
                if(!charToString.get(c).equals(s))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // expected true
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        // expected false
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        // expected false
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        // expected true
        System.out.println(wordPattern("abbc", "dog cat cat fish"));

    }
}
