import java.util.HashMap;

public class TwoSum2 {

    // Given an array of integers that is already sorted in ascending order,
    // find two numbers such that they add up to a specific target number.
    // Return indices of the two numbers such that they add up to the target,
    // where index1 must be less than index2.
    // Your returned answers (both index1 and index2) are not zero-based.
    private static int[] twoSum(int[] numbers, int target) {
        int[] out = new int[2];

        // key is numbers[i], value is i
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbers.length; i++){
            int complement = target - numbers[i];
            // since array is sorted, complement will be the smaller half
            if(map.containsKey(complement)){
                out[0] = map.get(complement) + 1;
                out[1] = i + 1;
                return out;
            }
            else{
                map.put(numbers[i], i);
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
        // expected [1, 2]
        int[] solution1 = twoSum(nums, 9);
        System.out.println("[" + solution1[0] + ", " + solution1[1] + "]");

    }
}
