public class ReverseBits {

    // Reverse bits of a given 32 bits unsigned integer
    private static int reverseBits(int n) {
        int out = 0;
        for(int i = 0; i < 32; i++){
            // get the ith bit from the end
            int currBit = (n >> i) & 1;
            // reverse the bit value
            out += currBit << (31-i);
        }
        return out;
    }

    public static void main(String[] args) {
        // expected 964176192
        System.out.println(reverseBits(43261596));
        // expected -1073741825
        System.out.println(reverseBits(-3));

    }
}
