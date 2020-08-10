public class RemoveElement {

    // Given an array nums and a value val, remove all instances of that value in-place
    // and return the new length.
    // Do not allocate extra space for another array, you must do this by modifying the
    // input array in-place with O(1) extra memory.
    // The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    private static int removeElement(int[] nums, int val) {
        // strategy is similar to three way quicksort; group val's and push to end

        // where the block of val begins
        int begin = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val) {
                // first appearance
                if (begin == -1) {
                    begin = i;
                }
            }
            else {
                // swap begin and i if begin is defined
                if(begin != -1){
                    swap(nums, begin, i);
                    begin++;
                }

            }
        }
        // none found
        if(begin == -1)
            return nums.length;

        // otherwise begin should be the index of the length
        return begin;
    }

    // swap values at a[i] and a[j]
    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,2,2,3,0,4,2};
        int len1 = removeElement(nums1, 2);
        // expected 0 1 3 0 4
        for(int i = 0; i < len1; i++)
            System.out.print(nums1[i] + " ");

        System.out.println();

        int[] nums2 = new int[]{3,2,2,3};
        int len2 = removeElement(nums2, 1);
        // expected 3 2 2 3 (no change)
        for(int i = 0; i < len2; i++)
            System.out.print(nums2[i] + " ");

    }
}
