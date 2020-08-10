public class RemoveDuplicatesFromSortedArray2 {

    // Given a sorted array nums, remove the duplicates in-place such that
    // duplicates appeared at most twice and return the new length.
    // Do not allocate extra space for another array, you must do this by
    // modifying the input array in-place with O(1) extra memory.
    private static int removeDuplicates(int[] nums) {
        // strategy is to have all duplicates pushed to the end together

        // the value in nums that is currently up to twice duplicated
        int tempVal = nums[0];
        // the number of occurrences of tempVal
        int tempCount = 1;
        // the beginning of the 3+ duplicates
        int begin = -1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == tempVal)
                tempCount++;
            else {
                tempVal = nums[i];
                tempCount = 1;
            }
            // need to remove these duplicates
            if(tempCount > 2){
                if(begin == -1)
                    begin = i;
            }
            else{
                if(begin != -1){
                    swap(nums, begin, i);
                    begin++;
                }
            }
        }

        // no 3+ duplicates to remove
        if(begin == -1)
            return nums.length;

        return begin;
    }

    // swap values at a[i] and a[j]
    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,2,2,3};
        int len1 = removeDuplicates(nums1);
        // expected 1 1 2 2 3
        for (int i = 0; i< len1; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println();

        int[] nums2 = new int[]{0,0,1,1,1,1,2,3,3};
        int len2 = removeDuplicates(nums2);
        // expected 0 0 1 1 2 3 3
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
