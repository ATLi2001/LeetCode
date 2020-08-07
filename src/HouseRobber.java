public class HouseRobber {

    // solution with dynamic programming
    // https://medium.com/outco/how-to-solve-the-house-robber-problem-f3535ebaef1b
    private static int rob(int[] nums){
        int currMax = 0;
        int prevMax = 0;

        for(int i = 0; i < nums.length; i++){
            int newHouse = nums[i];
            int newMax = Math.max(currMax, prevMax + newHouse);
            prevMax = currMax;
            currMax = newMax;
        }

        return currMax;
    }

    // initial solution with recursion
//    // cannot rob two adjacent houses
//    private static int rob(int[] nums) {
//        return robHelper(nums, 0, nums.length - 1);
//    }
//
//    // recursive helper function for robbing a subarray of nums[]
//    // i is start index, j is end index
//    private static int robHelper(int[] nums, int i, int j){
//        // stop conditions
//        // if subarray is length 2, just choose the max
//        if((i + 1) == j)
//            return Math.max(nums[i], nums[j]);
//        // if subarray is length 1, return
//        if(i == j)
//            return nums[i];
//        // if i is greater than j, nothing to rob
//        if(i > j)
//            return 0;
//
//        // two recursive cases
//        // included nums[i] and thus recurse starting from the next non adjacent index
//        int included = nums[i] + robHelper(nums, i + 2, j);
//        // if nums[i] is not included, include nums[i+1] and then recurse from next non adjacent index
//        int notIncluded = nums[i+1] + robHelper(nums, i + 3, j);
//
//        return Math.max(included, notIncluded);
//    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,1};
        // expected 4
        System.out.println("nums1: " + rob(nums1));

        int[] nums2 = new int[]{2,7,9,3,1};
        // expected 12
        System.out.println("nums2: " + rob(nums2));
    }
}
