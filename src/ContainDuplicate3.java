import java.util.TreeSet;

public class ContainDuplicate3 {

    // Given an array of integers, find out whether there are two distinct indices i and j in the array
    // such that the absolute difference between nums[i] and nums[j] is at most t
    // and the absolute difference between i and j is at most k.
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // treeset of at most size k
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            // check least number greater than nums[i]
            if(set.ceiling(nums[i]) != null){
                if(set.ceiling(nums[i]) - nums[i] <= t)
                    return true;
            }
            // check greatest number less than nums[i]
            if(set.floor(nums[i]) != null){
                if(nums[i] - set.floor(nums[i]) <= t)
                    return true;
            }

            set.add(nums[i]);

            // check size
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,1};
        // expected true
        System.out.println(containsNearbyAlmostDuplicate(nums1, 3, 0));

        int[] nums2 = new int[]{1,0,1,1};
        // expected true
        System.out.println(containsNearbyAlmostDuplicate(nums2, 1, 2));

        int[] nums3 = new int[]{1,5,9,1,5,9};
        // expected false
        System.out.println(containsNearbyAlmostDuplicate(nums3, 2, 3));

    }
}
