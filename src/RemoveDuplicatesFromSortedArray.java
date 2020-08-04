public class RemoveDuplicatesFromSortedArray {

    // Given a sorted array nums, remove the duplicates in-place such that
    // each element appear only once and return the new length.
    // Do not allocate extra space for another array, you must do this by
    // modifying the input array in-place with O(1) extra memory.
    // It doesn't matter what you leave beyond the returned length.
    private static int removeDuplicates(int[] nums) {
        int len = 0;

        // where the duplicate chunks will begin and end
        int begin = 1;

        for(int i = 0; i < nums.length; i++){
            // first element is unique
            if(i == 0){
                len++;
            }
            // check for duplicates
            else{
                // distinct number
                if(nums[i] != nums[begin-1]){
                    len++;
                    // swap
                    swap(nums, i, begin);
                    begin++;
                }

            }

        }

        return len;
    }

    // swap values at a[i] and a[j]
    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 1, 2};
        int len1 = removeDuplicates(nums1);
        // expected 1 2
        for (int i = 0; i< len1; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println();

        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len2 = removeDuplicates(nums2);
        // expected 0 1 2 3 4
        for (int i = 0; i< len2; i++) {
            System.out.print(nums2[i] + " ");
        }

        System.out.println();

        int[] nums3 = new int[]{0,3,4};
        int len3 = removeDuplicates(nums3);
        // expected 0 3 4
        for (int i = 0; i< len3; i++) {
            System.out.print(nums3[i] + " ");
        }

    }
}
