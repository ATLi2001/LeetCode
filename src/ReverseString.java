public class ReverseString {

    // Do not allocate extra space for another array,
    // you must do this by modifying the input array in-place with O(1) extra memory.
    private static void reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++)
            swap(s, i, s.length - 1 - i);
    }

    // swap values at a[i] and a[j]
    private static void swap(char[] a, int i, int j){
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        char[] s1 = "hello".toCharArray();
        reverseString(s1);
        // expected o l l e h
        for(int i = 0; i < s1.length; i++)
            System.out.print(s1[i] + " ");

        System.out.println();

        char[] s2 = "Hannah".toCharArray();
        reverseString(s2);
        // expected h a n n a H
        for(int i = 0; i < s2.length; i++)
            System.out.print(s2[i] + " ");
    }
}
