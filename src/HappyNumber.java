import java.util.HashSet;

public class HappyNumber {

    // A happy number is a number defined by the following process:
    // Starting with any positive integer, replace the number by the
    // sum of the squares of its digits, and repeat the process until
    // the number equals 1 (where it will stay), or it loops endlessly
    // in a cycle which does not include 1. Those numbers for which this
    // process ends in 1 are happy numbers.
    private static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = sumSquareDigits(n);
        }

        return n == 1;
    }

    // return the sum of the squares of the digits of n
    private static int sumSquareDigits(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // expected true
        System.out.println(isHappy(1));
        // expected true;
        System.out.println(isHappy(19));
        // expected false
        System.out.println(isHappy(4));

    }
}
