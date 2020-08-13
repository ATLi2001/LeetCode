import java.util.*;

public class ThreeSum {

    // Given an array nums of n integers, are there elements a, b, c in nums
    // such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    // no duplicates in return
    private static List<List<Integer>> threeSum(int[] nums) {
        // to prevent repeats
        Set<List<Integer>> out = new HashSet<>();

        // map of nums[i] to i
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        // check pairs of nums, use map for third entry
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int complement = 0 - nums[i] - nums[j];
                if(map.containsKey(complement)){
                    int k = map.get(complement);
                    // make sure not repeating an index or triple
                    if(i != k && j != k && k > j){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(complement);
                        // so hashset can recognize repeated sets
                        Collections.sort(temp);
                        out.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(out);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ts = threeSum(nums);

        // expected
        // -1 0 1
        // -1 -1 2
        for(int i = 0; i < ts.size(); i++){
            for(int j = 0; j < ts.get(0).size(); j++){
                System.out.print(ts.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
