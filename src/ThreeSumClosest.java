import java.util.Arrays;

public class ThreeSumClosest {

    // Given an array nums of n integers and an integer target, find three integers
    // in nums such that the sum is closest to target. Return the sum of the three integers.
    // You may assume that each input would have exactly one solution.
    private static int threeSumClosest(int[] nums, int target) {
        // use two pointer idea

        int closest = Integer.MAX_VALUE;

        // sort nums
        Arrays.sort(nums);

        // use -2 so have room for next two pointers
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                int tmpSum = nums[i] + nums[j] + nums[k];
                // if equal than done
                if(tmpSum == target)
                    return tmpSum;
                // update closest if necessary
                if(Math.abs(target - tmpSum) < Math.abs(target - closest)){
                    closest = tmpSum;
                }

                if(tmpSum < target)
                    j++;
                if(tmpSum > target)
                    k--;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        // expected 2
        System.out.println(threeSumClosest(nums, 1));
        // expected -3
        System.out.println(threeSumClosest(nums, -3));
    }
}
