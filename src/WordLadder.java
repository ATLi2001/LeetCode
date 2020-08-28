import java.util.*;

public class WordLadder {

    // Find the length of shortest transformation sequence from beginWord to endWord, such that:
    // Only one letter can be changed at a time.
    // Each transformed word must exist in the word list.
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create a graph adjacency list
        // key is string, value is adjacent strings (one letter changed)
        Map<String, List<String>> graph = new HashMap<>();
        graph.put(beginWord, adjStrings(beginWord, wordList));
        for(String s : wordList){
            graph.put(s, adjStrings(s, wordList));
        }
        // make sure endWord is a vertex in the graph
        if(!graph.containsKey(endWord))
            return 0;


        // use BFS
        Queue<String> queue = new LinkedList<>();
        // use hashset to track visited
        HashSet<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int len = 1;
        while(!queue.isEmpty()){
            // go through all elements that are len away from beginWord
            int size = queue.size();
            for(int j = 0; j < size; j++){
                String currWord = queue.poll();
                // add back into queue possible next words
                for(String s : graph.get(currWord)){
                    if(s.equals(endWord)){
                        return len + 1;
                    }
                    if(!visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
            len++;
        }

        // shouldn't get here because endWord should be found
        return len;
    }

    // return a list of strings that are only one letter different to string key
    private static List<String> adjStrings(String key, List<String> list){
        List<String> out = new ArrayList<>();
        for(String s : list){
            int dif = 0;
            for(int i = 0; i < key.length(); i++){
                if(key.charAt(i) != s.charAt(i))
                    dif++;
                if(dif > 1)
                    break;
            }
            if(dif == 1)
                out.add(s);
        }
        return out;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        // expected 5
        System.out.println(ladderLength("hit", "cog", wordList));
        // expected 0
        System.out.println(ladderLength("jot", "xyz", wordList));
    }
}
