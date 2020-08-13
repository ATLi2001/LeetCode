import java.util.*;

public class SortCharactersByFrequency {

    private static class frequencyCompareReverse implements Comparator<Map.Entry<Character, Integer>> {
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            return -o1.getValue().compareTo(o2.getValue());
        }
    }

    private static String frequencySort(String s) {
        // key is a char in s, value is its frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // first apperance
            if(!map.containsKey(c))
                map.put(c, 1);
            else
                map.replace(c, map.get(c) + 1);
        }

        List<Map.Entry<Character, Integer>> sList = new ArrayList<>(map.entrySet());
        Collections.sort(sList, new frequencyCompareReverse());

        StringBuilder out = new StringBuilder();
        for(int i = 0; i < sList.size(); i++){
            char c = sList.get(i).getKey();
            int freq = sList.get(i).getValue();
            for(int j = 0; j < freq; j++)
                out.append(c);
        }

        return out.toString();
    }

    public static void main(String[] args) {
        // expected eert
        System.out.println(frequencySort("tree"));
        // expected aaaccc
        System.out.println(frequencySort("cccaaa"));
        // expected bbAa
        System.out.println(frequencySort("Aabb"));
    }
}
