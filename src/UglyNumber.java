public class UglyNumber {

    // Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
    // treat 1 as ugly, non positive not ugly
    private static boolean isUgly(int num) {
        if(num <= 0)
            return false;
        if(num == 1)
            return true;

        // check all factors
        // go up to num/2
        for(int i = 2; i <= num/2; i++){
            // evenly divisible so i is a factor of num
            if(num % i == 0)
                // i is not divisible by 2, 3, and 5 so num is not ugly
                if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0)
                    return false;
        }
        // ugly
        return true;
    }

    public static void main(String[] args) {
        // boundary cases such as 1, 0, and negative
        // expected true
        System.out.println(isUgly(1));
        // expected false
        System.out.println(isUgly(0));
        // expected false
        System.out.println(isUgly(-23));
        // expected true
        System.out.println(isUgly(8));
        // expected false
        System.out.println(isUgly(14));
        // expected true
        System.out.println(isUgly(30));

    }
}
