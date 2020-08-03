import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] two_sum(int[] nums, int target) {
        int[] out = new int[2];

        // pairs of number and index
        Map<Integer, Integer> pairs = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            pairs.put(nums[i], i);

        for(int i = 0; i < nums.length; i++){
            int curr_target = target - nums[i];
            // check if the current target is present
            // also make sure that the current target isn't the current number itself
            if(pairs.containsKey(curr_target) && pairs.get(curr_target) != i){
                out[0] = i;
                out[1] = pairs.get(curr_target);
                return out;
            }
        }
        // not found
        out[0] = -1;
        out[1] = -1;
        return out;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 2, 7, 11, 15 };

        // standard working case
        // expected [0, 1]
        int[] solution1 = two_sum(nums, 9);
        System.out.println("[" + solution1[0] + ", " + solution1[1] + "]");

        // shouldn't work because can't have repeated
        // expected [-1, -1]
        int[] solution2 = two_sum(nums, 4);
        System.out.println("[" + solution2[0] + ", " + solution2[1] + "]");
    }
}
