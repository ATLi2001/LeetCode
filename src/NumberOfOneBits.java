public class NumberOfOneBits {

    // number of one bits is the Hamming weight
    private static int hammingWeight(int n) {
        int count = 0;

        for(int i = 0; i < 32; i++){
            // get the ith bit from the end
            int currBit = (n >> i) & 1;
            if(currBit != 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // expected 3
        System.out.println(hammingWeight(11));
        // expected 1
        System.out.println(hammingWeight(128));
        // expected 31
        System.out.println(hammingWeight(-3));
    }
}
