public class ReverseVowels {

    private static String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        // i from beginning, j from end
        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            // stop only at vowels
            if(!isVowel(chars[i]))
                i++;
            if(!isVowel(chars[j]))
                j--;

            // at two vowels
            if(isVowel(chars[i]) && isVowel(chars[j])) {
                swap(chars, i, j);
                i++;
                j--;
            }
        }

        return String.valueOf(chars);
    }

    // The vowels does not include the letter "y"
    private static boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }

    // swap values at a[i] and a[j]
    private static void swap(char[] a, int i, int j){
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        // expected holle
        System.out.println(reverseVowels("hello"));
        // expected leotcede
        System.out.println(reverseVowels("leetcode"));
        // expected bye
        System.out.println(reverseVowels("bye"));

    }
}
