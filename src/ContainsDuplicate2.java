import java.util.HashMap;

public class ContainsDuplicate2 {

    // are there duplicates that are k indices within each other?
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        // key is an element of nums, value is most recent index seen
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // first appearance
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else{
                // check index difference
                if(i - map.get(nums[i]) <= k)
                    return true;
                else
                    map.replace(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,1};
        // expected true
        System.out.println("num1: " + containsNearbyDuplicate(nums1, 3));

        int[] nums2 = new int[]{1,0,1,1};
        // expected true
        System.out.println("nums2: " + containsNearbyDuplicate(nums2, 1));

        int[] nums3 = new int[]{1,2,3,1,2,3};
        // expected false
        System.out.println("nums3: " + containsNearbyDuplicate(nums3, 2));

    }
}
