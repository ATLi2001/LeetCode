public class ContainerWithMostWater {

    // Given n non-negative integers a1, a2, ..., an , where each represents
    // a point at coordinate (i, ai). n vertical lines are drawn such that the
    // two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
    // together with x-axis forms a container, such that the container contains
    // the most water.
    // You may not slant the container and n is at least 2.
    private static int maxArea(int[] height) {
        int max = 0;

        // pointers from beginning and end
        int begin = 0;
        int end = height.length - 1;

        // temporary area
        int tmp = 0;

        while(begin < end){
            // calculate area and compare
            tmp = (end - begin) * Math.min(height[begin], height[end]);
            if(tmp > max)
                max = tmp;

            // move the side with less height
            if(height[begin] < height[end])
                begin++;
            else
                end--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        // expected 49
        System.out.println(maxArea(heights));

    }
}
