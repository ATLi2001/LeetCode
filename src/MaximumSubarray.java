public class MaximumSubarray {

    private static int maxSubArray(int[] nums) {
        // corner case of empty nums
        if(nums.length == 0)
            return 0;

        int maxSum = Integer.MIN_VALUE;
        int tmpSum = 0;

        for(int i = 0; i < nums.length; i++){
            tmpSum += nums[i];
            // compare with maxSum
            if(tmpSum > maxSum)
                maxSum = tmpSum;

            // if tmpSum ends up non positive, reset since including that subarray won't increase maxSum
            if (tmpSum <= 0) {
                tmpSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int sum1 = maxSubArray(nums1);
        // expected 6
        System.out.println("sum1: " + sum1);

        int[] nums2 = new int[]{1,2,3,4};
        int sum2 = maxSubArray(nums2);
        // expected 10
        System.out.println("sum2: " + sum2);

        int[] nums3 = new int[]{-5,-2,-3,-4};
        int sum3 = maxSubArray(nums3);
        // expected -2
        System.out.println("sum3: " + sum3);

        int[] nums4 = new int[]{1,-2,3,4};
        int sum4 = maxSubArray(nums4);
        // expected 7
        System.out.println("sum4: " + sum4);

    }
}
