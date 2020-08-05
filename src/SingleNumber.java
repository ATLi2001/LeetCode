import java.util.HashMap;

public class SingleNumber {

    // Given a non-empty array of integers, every element appears twice except for one
    // Find that single one
    private static int singleNumber(int[] nums) {
        // track the number of times each number appears
        // key is the an element of nums[]
        // value is number of occurences
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // first appearance
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            // second appearance
            else
                map.remove(nums[i]);
        }

        // only remaining key in map is the single
        for(Integer key : map.keySet())
            return key;

        // shouldn't get here
        return 0;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{2,2,1};
        // expected 1
        System.out.println("a1: " + singleNumber(a1));

        int[] a2 = new int[]{4,1,2,1,2};
        // expected 4
        System.out.println("a1: " + singleNumber(a2));
    }
}
