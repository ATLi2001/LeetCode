public class SumOfTwoIntegers {

    // not allowed to use the operator + and -
    private static int getSum(int a, int b) {
        // use bitwise operations
        int out = 0;
        int carry = 0;
        for(int i = 0; i < 32; i++){
            // to put in at the ith bit from the end of out
            int outBit = 0;

            // get the ith bit from the end
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;

            // determine if need to carry
            if(aBit == 1 && bBit == 1 && carry == 1) {
                carry = 1;
                outBit = 1;
            }
            else if(aBit == 1 && bBit == 1 && carry == 0)
                carry = 1;
            else if(aBit == 1 && bBit == 0 && carry == 1)
                carry = 1;
            else if(aBit == 0 && bBit == 1 && carry == 1)
                carry = 1;
            else if(aBit == 0 && bBit == 0 && carry == 0)
                outBit = 0;
            else {
                carry = 0;
                outBit = 1;
            }

            // bitwise or operation
            out |= (outBit << i);

        }
        return out;
    }

    public static void main(String[] args) {
        // expected 4
        System.out.println(getSum(1,3));
        // expected 1
        System.out.println(getSum(-2, 3));
        // expected 65
        System.out.println(getSum(25, 40));
    }
}
