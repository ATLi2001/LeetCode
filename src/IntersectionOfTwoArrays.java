import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

    // Each element in the result must be unique
    private static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> intersect = new ArrayList<>();

        // a set of all unique elements of nums1
        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            set1.add(nums1[i]);

        // a set of all unique elements of nums2
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums2.length; i++) {
            // don't want to repeat check elements
            if(!set2.contains(nums2[i])) {
                // intersection
                if (set1.contains(nums2[i]))
                    intersect.add(nums2[i]);
            }
            set2.add(nums2[i]);
        }

        // convert back to array to return
        int[] out = new int[intersect.size()];
        for(int i = 0; i < intersect.size(); i++)
            out[i] = intersect.get(i);

        return out;
    }

    public static void main(String[] args) {
        int[] nums11 = new int[]{1,2,2,1};
        int[] nums12 = new int[]{2,2};
        int[] inter1 = intersection(nums11, nums12);
        // expected 2
        for(int i = 0; i < inter1.length; i++)
            System.out.print(inter1[i] + " ");

        System.out.println();

        int[] nums21 = new int[]{4,9,5};
        int[] nums22 = new int[]{9,4,9,8,4};
        int[] inter2 = intersection(nums21, nums22);
        // expected 9 4
        for(int i = 0; i < inter2.length; i++)
            System.out.print(inter2[i] + " ");
    }
}
