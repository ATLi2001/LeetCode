public class KthLargestElement {

    // kth largest
    private static int findKthLargest(int[] nums, int k) {
        // use quickselect
        // kth largest is equivalent to index nums.length - k in sorted array
        return findKthLargestHelper(nums, nums.length - k, 0, nums.length - 1);
    }

    private static int findKthLargestHelper(int[] nums, int k, int lo, int hi){
        if(lo >= hi)
            return nums[lo];

        // pivot will be nums[lo]
        int pivot = nums[lo];
        // front and back pointers
        int i = lo + 1;
        int j = hi;

        while(i <= j){
            if(nums[i] < pivot)
                i++;
            else{
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, lo, j);

        if(j == k)
            return nums[j];
        else if(j < k)
            return findKthLargestHelper(nums, k, j+1, hi);
        else
            return findKthLargestHelper(nums, k, lo, j-1);
    }

    // swap values at a[i] and a[j]
    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        // expected 4
        System.out.println(findKthLargest(nums, 4));

    }
}
