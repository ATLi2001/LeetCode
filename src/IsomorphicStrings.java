import java.util.HashMap;

public class IsomorphicStrings {

    private static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        // map each char in s to a char in t
        HashMap<Character, Character> s2t = new HashMap<>();
        // map each char in t to a char in s
        HashMap<Character, Character> t2s = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // new char in s
            if(!s2t.containsKey(sChar)){
                // make sure t doesn't already have corresponding
                if(t2s.containsKey(tChar))
                    return false;
                s2t.put(sChar, tChar);
                t2s.put(tChar, sChar);
            }
            // repeat char must have same as before
            else{
                if(!s2t.get(sChar).equals(tChar))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // expected true
        System.out.println(isIsomorphic("egg", "add"));
        // expected false
        System.out.println(isIsomorphic("bar", "foo"));
        // expected true
        System.out.println(isIsomorphic("paper", "title"));
    }
}
