import java.util.HashMap;

public class MaxPointsOnLine {

    private static int maxPoints(int[][] points) {
        // try every pair of points
        // edge case of same point

        int max = 0;

        for(int i = 0; i < points.length; i++){
            int[] iPoint = points[i];
            // track the slope and its occurrence
            HashMap<Double, Integer> slopes = new HashMap<>();
            for(int j = i + 1; j < points.length; j++){
                // skip duplicate points
                if(points[j][0] == iPoint[0] && points[j][1] == iPoint[1])
                    continue;

                double currSlope = getSlope(iPoint, points[j]);
                // first appearance
                if(!slopes.containsKey(currSlope)){
                    // 2 points on the line
                    slopes.put(currSlope, 2);
                }
                else{
                    slopes.replace(currSlope, slopes.get(currSlope) + 1);
                }
                // check against max
                if(slopes.get(currSlope) > max)
                    max = slopes.get(currSlope);
            }
        }
        return max;
    }

    // get slope between points a and b
    private static double getSlope(int[] a, int[] b){
        int deltaX = b[0] - a[0];
        int deltaY = b[1] - a[1];
        return (double)deltaY / deltaX;
    }

    public static void main(String[] args) {
        int[][] points1 = new int[][]{{1,1}, {2,2}, {3,3}};
        // expected 3
        System.out.println(maxPoints(points1));

        int[][] points2 = new int[][]{{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        // expected 4
        System.out.println(maxPoints(points2));
    }
}
