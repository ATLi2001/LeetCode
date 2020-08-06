public class FactorialTrailingZeroes {

    // Given an integer n, return the number of trailing zeroes in n!
    private static int trailingZeroes(int n) {
        // classic math problem - count number of powers of 5
        int count = 0;

        // power of 5 to divide by
        int power = 1;

        while(n / (Math.floor(Math.pow(5, power))) > 0){
            count += n / (Math.floor(Math.pow(5, power)));
            power++;
        }

        return count;
    }

    public static void main(String[] args) {

        // expected 0
        System.out.println(trailingZeroes(3));
        // expected 1
        System.out.println(trailingZeroes(5));
        // expected 6
        System.out.println(trailingZeroes(25));

    }
}
