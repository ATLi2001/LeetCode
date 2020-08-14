import java.util.HashMap;
import java.util.HashSet;

public class FourSum2 {

    // Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
    // there are such that A[i] + B[j] + C[k] + D[l] is zero.
    // A, B, C, D have same length of N
    private static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // strategy to use a hashset for D and try all triples of A,B,C

        int N = A.length;
        int count = 0;

        // initial strategy takes n^3 time
//        // all values of D
//        HashSet<Integer> Dset = new HashSet<>();
//
//        for(int i = 0; i < N; i++){
//            Dset.add(D[i]);
//        }
//
//        for(int a = 0; a < N; a++){
//            for(int b = 0; b < N; b++){
//                for(int c = 0; c < N; c++){
//                    int complement = 0 - A[a] - B[b] - C[c];
//                    if(Dset.contains(complement))
//                        count++;
//                }
//            }
//        }


        // new strategy to look at A and B together, then C and D; take n^2 time

        // key is pair sum, value is number of occurrences
        HashMap<Integer, Integer> ABmap = new HashMap<>();
        for(int a = 0; a < N; a++){
            for(int b = 0; b < N; b++){
                int currSum = A[a] + B[b];
                if(!ABmap.containsKey(currSum))
                    ABmap.put(currSum, 1);
                else
                    ABmap.replace(currSum, ABmap.get(currSum) + 1);
            }
        }

        // now loop through C,D
        for(int c = 0; c < N; c++){
            for(int d = 0; d < N; d++){
                int complement = 0 - C[c] - D[d];
                if(ABmap.containsKey(complement))
                    count += ABmap.get(complement);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        // expected 2
        System.out.println(fourSumCount(A, B, C, D));
    }
}
