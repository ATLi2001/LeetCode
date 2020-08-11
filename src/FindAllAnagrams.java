import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {

    // Given a string s and a non-empty string p, find all the start indices of p's anagrams in s
    // Strings consists of lowercase English letters only
    private static List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length())
            return new ArrayList<>();

        List<Integer> out = new ArrayList<>();

        // track occurrences of chars in p
        HashMap<Character, Integer> pMap = new HashMap<>();
        // initial substring of s
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            // first appearance in p
            if(!pMap.containsKey(c))
                pMap.put(c, 1);
            else
                pMap.replace(c, pMap.get(c) + 1);

            c = s.charAt(i);
            // first appearance in s
            if(!sMap.containsKey(c))
                sMap.put(c, 1);
            else
                sMap.replace(c, sMap.get(c) + 1);
        }

        // where each substring will start
        int left = 0;
        // where substring will end
        int right = left + p.length();
        // go through possible substrings of proper length
        while(right <= s.length()){
            // check if are anagrams
            if(isAnagram(sMap, pMap))
                out.add(left);

            // no need to check next character
            if(right == s.length())
                return out;

            // if next character is not in p, then skip to after it
            if(!pMap.containsKey(s.charAt(right))){
                left = right + 1;
                right = left + p.length();

                // make sure right is in bounds
                if(right > s.length())
                    return out;

                // redo sMap
                sMap.clear();
                for(int i = left; i < right; i++){
                    char c = s.charAt(i);
                    // first appearance in s
                    if(!sMap.containsKey(c))
                        sMap.put(c, 1);
                    else
                        sMap.replace(c, sMap.get(c) + 1);
                }
            }
            // if next character is in p, iterate by 1
            else{
                // get rid of left char
                // only one occurrence
                if(sMap.get(s.charAt(left)) == 1)
                    sMap.remove(s.charAt(left));
                // else decrease occurrence by 1
                else
                    sMap.replace(s.charAt(left), sMap.get(s.charAt(left)) - 1);

                // add in right char
                if(!sMap.containsKey(s.charAt(right)))
                    sMap.put(s.charAt(right), 1);
                else
                    sMap.replace(s.charAt(right), sMap.get(s.charAt(right)) + 1);

                left++;
                right++;
            }
        }

        return out;
    }

    // a, b represent maps where key is a char in the string it represents
    // and value is the number of occurrences
    private static boolean isAnagram(HashMap<Character, Integer> a, HashMap<Character, Integer> b){
        if(a.size() != b.size())
            return false;

        for(char c : a.keySet()){
            if(!b.containsKey(c))
                return false;
            if(!a.get(c).equals(b.get(c)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> l1 = findAnagrams("cbaebabacd", "abc");
        // expected 0 6
        for(int i : l1)
            System.out.print(i + " ");

        System.out.println();

        List<Integer> l2 = findAnagrams("abab", "ab");
        // expected 0 1 2
        for(int i : l2)
            System.out.print(i + " ");

    }
}
