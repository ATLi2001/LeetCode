public class ValidPalindrome {

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases
    private static boolean isPalindrome(String s) {
        // empty string is valid
        if(s.length() == 0)
            return true;

        // i to index from beginning, j to index from end
        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            while(!isLetterOrDigit(s.charAt(i)))
                i++;
            while(!isLetterOrDigit(s.charAt(j)))
                j--;
            if(Character.toLowerCase(s.charAt(i)) !=
                    Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s0 = "";
        // expected true
        System.out.println("s0: " + isPalindrome(s0));

        String s1 = "A man, a plan, a canal: Panama";
        // expected true
        System.out.println("s1: " + isPalindrome(s1));

        String s2 = "race a car";
        // expected false
        System.out.println("s2: " + isPalindrome(s2));

    }
}
