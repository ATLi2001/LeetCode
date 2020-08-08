public class PowerOfFour {

    private static boolean isPowerOfFour(int num) {
        if(num <= 0)
            return false;

        // while num is divisible by 4, divide
        while(num % 4 == 0)
            num /= 4;

        // if by the end are left with 1, then is a power of four
        return num == 1;
    }

    public static void main(String[] args) {
        // boundary case of negative numbers
        // expected false
        System.out.println(isPowerOfFour(-16));
        // expected true
        System.out.println(isPowerOfFour(1));
        // expected true
        System.out.println(isPowerOfFour(16));
        // expected false
        System.out.println(isPowerOfFour(20));

    }
}
