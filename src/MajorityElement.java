import java.util.HashMap;

public class MajorityElement {

    // The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    // You may assume that the array is non-empty and the majority element always exist in the array.
    private static int majorityElement(int[] nums) {
        // need to have greater than half to be majority
        int half = nums.length/2;

        // key is element of nums, value is occurence
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // first occurrence
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else if(map.get(nums[i]) + 1 > half)
                return nums[i];
            else
                map.replace(nums[i], map.get(nums[i]) + 1);
        }

        // should not get here
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,3};
        // expected 3
        System.out.println("nums1: " + majorityElement(nums1));

        int[] nums2 = new int[]{2,2,1,1,1,2,2};
        // expected 2
        System.out.println("nums2: " + majorityElement(nums2));
    }
}
