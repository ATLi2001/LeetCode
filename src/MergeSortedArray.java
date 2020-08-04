public class MergeSortedArray {

    // nums1.length == m + n
    // nums2.length == n
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // initial solution isn't in place

//        // copy of initialized elements of nums1
//        int[] copy = new int[m];
//        for(int i = 0; i < m; i++)
//            copy[i] = nums1[i];
//
//        // indices into copy and nums2, respectively
//        int i = 0;
//        int j = 0;
//        // index into nums1
//        int k = 0;
//
//        // merge sort
//        while(i < m && j < n){
//            // see which is smaller
//            if(copy[i] < nums2[j]){
//                nums1[k] = copy[i];
//                i++;
//            }
//            else{
//                nums1[k] = nums2[j];
//                j++;
//            }
//            k++;
//        }
//
//        // only one of the following will be executed
//        for(; i < m; i++, k++)
//            nums1[k] = copy[i];
//        for(; j < n; j++, k++)
//            nums1[k] = nums2[j];


        // in place solution goes from reverse, largest to smallest
        // indices of elements to be sorted
        int i = m-1;
        int j = m-1;
        // index of where to place
        int k = m + n - 1;

        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // copy in the rest
        for(; j >= 0; j--, k--)
            nums1[k] = nums2[j];

        // if i >= 0 don't need to do anything since already in nums1

    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        for(int i = 0; i < nums1.length; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}
