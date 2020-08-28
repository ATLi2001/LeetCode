import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {

    private static int[] topKFrequent(int[] nums, int k) {

        // tally frequency counts for each element of nums
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.replace(i, map.get(i) + 1);
        }

        // map counts to number
        HashMap<Integer, List<Integer>> reverse = new HashMap<>();
        // use key indexed counting to sort frequencies
        int[] counts = new int[nums.length + 1];
        for(int key : map.keySet()){
            if(!reverse.containsKey(map.get(key))){
                List<Integer> temp = new ArrayList<>();
                temp.add(key);
                reverse.put(map.get(key), temp);
            }
            else{
                reverse.get(map.get(key)).add(key);
            }
            counts[map.get(key)]++;
        }

        // get by frequency descending
        List<Integer> out = new ArrayList<>();
        for(int i = counts.length-1; i >= 0; i--){
            if(counts[i] != 0){
                if(counts[i] <= k)
                    out.addAll(reverse.get(i));
                else{
                    for(int l = 0; l < k; l++){
                        out.add(reverse.get(i).get(l));
                    }
                }
            }
            k -= counts[i];
            if(k <= 0) {
                int[] arr = new int[out.size()];
                for(int j = 0; j < arr.length; j++)
                    arr[j] = out.get(j);
                return arr;
            }
        }
        // should not get here
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] out = topKFrequent(nums, 2);
        // expected 1 2
        for(int i : out)
            System.out.print(i + " ");
    }
}
