import java.util.HashMap;

public class NumberOfBoomerangs {

    // Given n points in the plane that are all pairwise distinct,
    // a "boomerang" is a tuple of points (i, j, k) such that the
    // distance between i and j equals the distance between i and k
    // (the order of the tuple matters).
    private static int numberOfBoomerangs(int[][] points) {
        // strategy is for each point as i, use a hashmap of the distances to the other points

        int count = 0;

        for(int i = 0; i < points.length; i++){
            int[] iPoint = points[i];
            // key is squared distance, value is number of occurrences
            HashMap<Integer, Integer> distCounts = new HashMap<>();

            // go through all other points except iPoint
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    int d = squaredDist(iPoint, points[j]);
                    // first appearance
                    if(!distCounts.containsKey(d))
                        distCounts.put(d, 1);
                    else
                        distCounts.replace(d, distCounts.get(d) + 1);
                }
            }
            // tally up the repeated distances to count
            for(int key : distCounts.keySet()){
                // only possible to form a triple if occurrence > 1
                int currCount = distCounts.get(key);
                if(currCount > 1){
                    // counting principle for permutations
                    count += currCount * (currCount - 1);
                }
            }
        }

        return count;
    }

    // return the squared distance between points a and b
    private static int squaredDist(int[] a, int[] b){
        int deltaX = b[0] - a[0];
        int deltaY = b[1] - a[1];
        return deltaX * deltaX + deltaY * deltaY;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0}, {1,0}, {2,0}};
        // expected 2
        System.out.println(numberOfBoomerangs(points));
    }
}
