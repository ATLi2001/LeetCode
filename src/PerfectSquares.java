import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

    // Given a positive integer n, find the least number of perfect square numbers
    // which sum to n.
    private static int numSquares(int n) {
        // number of perfect squares used so far
        int count = 0;

        // largest number x such that x^2 <= n
        int maxSquare = 0;
        while(maxSquare * maxSquare <= n)
            maxSquare++;

        // use a BFS type of search
        // each level of the queue will be the number of steps to get to that number
        // each element will be n - some squares
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        // use hashset to not add repeated numbers to queue
        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                if(curr == 0){
                    return count;
                }

                for(int j = maxSquare; j > 0; j--) {
                    int temp = curr - j * j;
                    if(!set.contains(temp))
                        queue.add(temp);
                }
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        // expected 3
        System.out.println(numSquares(12));
        // expected 2
        System.out.println(numSquares(13));
    }
}
