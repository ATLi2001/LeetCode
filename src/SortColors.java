public class SortColors {

    // Given an array with n objects colored red, white or blue, sort them in-place
    // so that objects of the same color are adjacent, with the colors in the order red, white and blue.
    // Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    // Do not use library sort function.
    private static void sortColors(int[] nums) {
        // use three way quicksort
//        sortColorsHelper(nums, 0, nums.length - 1);

        // do it in one pass
        // since we know that there are only three colors, we can do better than general three way quicksort

        // where the red ends
        int red = 0;
        // where the blue begins
        int blue = nums.length - 1;

        int i = 0;

        while(i <= blue){
            // red goes in front
            if(nums[i] == 0){
                swap(nums, red, i);
                red++;
                i++;
            }
            // blue to the end
            else if(nums[i] == 2){
                swap(nums, i, blue);
                blue--;
            }
            // leave white as is
            else{
                i++;
            }

        }

    }

    // recursive helper function for sorting from i to j, inclusive
    private static void sortColorsHelper(int[] nums, int start, int end){
        if(start >= end)
            return;

        int pivot = nums[start];
        // start index of block equal to pivot
        int lt = start;
        // end index of block equal to pivot
        int gt = start;

        int i = start + 1;
        int j = end;

        while(i <= j){
            // less than so swap pivot forward
            if(nums[i] < pivot) {
                swap(nums, i, lt);
                lt++;
                i++;
            }
            // greater than so swap nums[i] to end
            else if(nums[i] > pivot) {
                swap(nums, i, j);
                j--;
            }
            // equal
            else{
                i++;
                gt++;
            }
        }

        sortColorsHelper(nums, start, lt - 1);
        sortColorsHelper(nums, gt + 1, end);

    }

    // swap values at a[i] and a[j]
    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        // expected 0 0 1 1 2 2
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
