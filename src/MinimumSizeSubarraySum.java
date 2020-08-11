public class MinimumSizeSubarraySum {

    // Given an array of n positive integers and a positive integer s,
    // find the minimal length of a contiguous subarray of which the sum ≥ s.
    // If there isn't one, return 0 instead.
    private static int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            // track the sum of the current subarray
            int tmpSum = 0;
            // j is index of tmpSum
            int j = i;
            while(j < nums.length && tmpSum < s ) {
                // try to get to s
                tmpSum += nums[j];
                j++;
            }
            // didn't reach s after going through entire rest of array
            if(tmpSum < s) {
                // nothing was ever found
                if (minLen == Integer.MAX_VALUE)
                    return 0;
                return minLen;
            }
            else {
                minLen = Math.min(j - i, minLen);
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        // expected 2
        System.out.println(minSubArrayLen(7, nums));
        // expected 0
        System.out.println(minSubArrayLen(1000, nums));
    }
}
