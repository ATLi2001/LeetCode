import java.util.Arrays;

public class FindKthSmallestPairDistance {

    // Given an integer array, return the k-th smallest distance among all the pairs.
    // The distance of a pair (A, B) is defined as the absolute difference between A and B.
    private static int smallestDistancePair(int[] nums, int k) {
        // use key indexed counting idea

        // initial solution is n^2 time
//        // first sort nums
//        Arrays.sort(nums);
//
//        // find largest possible difference
//        int maxDist = nums[nums.length - 1] - nums[0];
//
//        // create the radix of possible distances (0 - maxDist inclusive)
//        int[] dist = new int[maxDist + 1];
//        // initialize all counts to 0
//        for(int i = 0; i < dist.length; i++)
//            dist[i] = 0;
//
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                // since nums is sorted, diff is non negative
//                int diff = nums[j] - nums[i];
//                dist[diff]++;
//            }
//        }
//
//        // get kth smallest
//        int distIndex = -1;
//        while(k > 0){
//            distIndex++;
//            k -= dist[distIndex];
//        }
//
//        // the index is the distance
//        return distIndex;

        // use binary search to help make n log n time

        Arrays.sort(nums);
        int maxDist = nums[nums.length - 1] - nums[0];

        // binary search from 0 to maxDist
        int lo = 0;
        int hi = maxDist;

        while(lo <= hi){
            // mid may not actually be an achievable distance
            int mid = lo + (hi - lo)/2;
            // check how many distances are less than or equal to mid
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                int j = i + 1;
                while(j < nums.length && nums[j] - nums[i] <= mid)
                    j++;
                // number that satisfied
                count += j - i - 1;
            }
            if(count < k)
                lo = mid + 1;
            else
                hi = mid - 1;

        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1};
        // expected 0
        System.out.println(smallestDistancePair(nums, 1));
        // expected 2
        System.out.println(smallestDistancePair(nums, 2));
    }
}
