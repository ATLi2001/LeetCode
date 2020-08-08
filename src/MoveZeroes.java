public class MoveZeroes {

    // move all 0's to the end of it while maintaining the relative order of the non-zero elements
    // You must do this in-place without making a copy of the array
    private static void moveZeroes(int[] nums) {
        // use strategy similar to three way quicksort

        // begin and end of 0 block
        int begin = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                // first 0 occurrence
                if(begin == -1){
                    begin = i;
                }
            }
            // swap beginning of 0 block with next number
            else{
                if(begin != -1){
                    swap(nums, begin, i);
                    begin++;
                }
            }
        }
    }

    // swap values at a[i] and a[j]
    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5};
        moveZeroes(nums1);
        // expected 1 2 3 4 5 (no change)
        for(int i = 0; i < nums1.length; i++)
            System.out.print(nums1[i] + " ");

        System.out.println();

        int[] nums2 = new int[]{0,1,0,3,12};
        moveZeroes(nums2);
        // expected 1 3 12 0 0
        for(int i = 0; i < nums2.length; i++)
            System.out.print(nums2[i] + " ");

        System.out.println();

        int[] nums3 = new int[]{0,1,0,0,0,1,0,0,1,0,0};
        moveZeroes(nums3);
        // expected 1 1 1 0 0 0 0 0 0 0 0
        for(int i = 0; i < nums3.length; i++)
            System.out.print(nums3[i] + " ");
    }
}
