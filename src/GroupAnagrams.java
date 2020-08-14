import java.util.*;

public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] strs) {
        // hashmap key is the alphabetically first anagram
        // i.e. if eat would be placed in as aet
        // value is the list
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.copyValueOf(chars);
            // first appearance
            if(!anagrams.containsKey(sorted)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                anagrams.put(sorted, tmp);
            }
            else{
                List<String> tmp = anagrams.get(sorted);
                tmp.add(s);
                anagrams.replace(sorted, tmp);
            }
        }

        // get the values of anagrams
        List<List<String>> out = new ArrayList<>();
        for(String key : anagrams.keySet()){
            out.add(anagrams.get(key));
        }
        return out;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = groupAnagrams(strs);

        // expected
        // ate eat tea
        // nat tan
        // bat
        for(int i = 0; i < groups.size(); i++){
            for(int j = 0; j < groups.get(i).size(); j++){
                System.out.print(groups.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
