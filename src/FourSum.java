import java.util.*;

public class FourSum {

    // Given an array nums of n integers and an integer target, are there elements
    // a, b, c, and d in nums such that a + b + c + d = target?
    // Find all unique quadruplets in the array which gives the sum of target
    // no duplicates in return
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        // to prevent repeats
        Set<List<Integer>> out = new HashSet<>();

        // map of nums[i] to i
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int complement = target - nums[i] - nums[j] - nums[k];
                    if(map.containsKey(complement)){
                        int m = map.get(complement);
                        // no repeat elements
                        if(m != i && m != j && m != k){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(complement);
                            // so hashset can recognize repeated sets
                            Collections.sort(temp);
                            out.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(out);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> fs = fourSum(nums, target);
        // expected
        // -1 0 0 1
        // -2 -1 1 2
        // -2 0 0 2
        for(int i = 0; i < fs.size(); i++){
            for(int j = 0; j < fs.get(0).size(); j++){
                System.out.print(fs.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
