public class ValidAnagram {

    // You may assume the string contains only lowercase alphabets.
    private static boolean isAnagram(String s, String t) {
        // solution below is with radix array
        // can also use hashmaps (see FindAllAnagrams.java)

        if(s.length() != t.length())
            return false;

        // radix count for lowercase letters
        int[] counts = new int[26];

        // +1 for each letter of s
        // -1 for each letter of t
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        // if all zeroes at end, then they are anagrams
        for(int i = 0; i < counts.length; i++) {
            if (counts[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // expected true
        System.out.println(isAnagram("anagram", "nagaram"));
        // expected false
        System.out.println(isAnagram("rat", "car"));
    }
}
