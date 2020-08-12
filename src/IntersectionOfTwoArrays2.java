import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays2 {

    // Each element in the result should appear as many times as it shows in both arrays.
    // The result can be in any order.
    private static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> out = new ArrayList<>();

        // keep a map of value and occurrence
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for(int i = 0; i < nums1.length; i++){
            if(!map1.containsKey(nums1[i]))
                map1.put(nums1[i], 1);
            else
                map1.replace(nums1[i], map1.get(nums1[i]) + 1);
        }

        // for each element of nums2, check against map1
        for(int i = 0; i < nums2.length; i++){
            if(map1.containsKey(nums2[i])){
                // only appearance
                if(map1.get(nums2[i]) == 1)
                    map1.remove(nums2[i]);
                else
                    map1.replace(nums2[i], map1.get(nums2[i]) - 1);
                // add to out
                out.add(nums2[i]);
            }
        }

        // convert out to array
        int[] outArr = new int[out.size()];
        for(int i = 0; i < outArr.length; i++)
            outArr[i] = out.get(i);
        return outArr;
    }

    public static void main(String[] args) {
        int[] nums11 = new int[]{1,2,2,1};
        int[] nums12 = new int[]{2,2};
        int[] inter1 = intersect(nums11, nums12);
        // expected 2 2
        for(int i = 0; i < inter1.length; i++)
            System.out.print(inter1[i] + " ");

        System.out.println();

        int[] nums21 = new int[]{4,9,5};
        int[] nums22 = new int[]{9,4,9,8,4};
        int[] inter2 = intersect(nums21, nums22);
        // expected 9 4
        for(int i = 0; i < inter2.length; i++)
            System.out.print(inter2[i] + " ");
    }
}
