
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

    public static void main(String[] args) {
        String[] words = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println("<<<<<<<<<<<<<<| with sort |>>>>>>>>>>>>>>");
        System.out.println(Arrays.toString(words));
        System.out.println("-----------------------------");
        System.out.println("<<<<<<<<<<<<<<| with sort |>>>>>>>>>>>>>>");
        List<List<String>> sort = groupAnagramsSort(words);
        System.out.println(sort);
        System.out.println("<<<<<<<<<<<<<<| with HashMap |>>>>>>>>>>>>>>");
        List<List<String>> hashmap = groupAnagramsHashMap(words);
        System.out.println(hashmap);

    }

//  Time complicity => O(m * n log n)
//  memory complicity => O(m * n)
//  m => the number of String 
//  n => the number of character for every String
    public static List<List<String>> groupAnagramsSort(String[] words) {
        Map<String, List<String>> mainMap = new HashMap<>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String wordSort = new String(charArray);
            mainMap.putIfAbsent(wordSort, new ArrayList<>());
            mainMap.get(wordSort).add(word);
        }
        return new ArrayList<>(mainMap.values());
    }

//  Time complicity => O(m * n)
//  memory complicity => O(m * n)
//  m => the number of String 
//  n => the number of character for every String
/*
 * Why Time complicity is not O(n^2) when we make nested loop ? 
 * this is not nested loop loop "why" =>
 *  because the fist loop for words Array, and second loop for each word to character,
 */

//  commit message => "Group Anagrams => Add Time & memory complicity, and some notes"
    public static List<List<String>> groupAnagramsHashMap(String[] words) {
        Map<String, List<String>> mainMap = new HashMap<>();
        for (String word : words) {
            int[] counter = new int[26];
            for (char c : word.toCharArray()) {
                counter[c - 'a']++;
            }
            String keyMap = Arrays.toString(counter);
            mainMap.putIfAbsent(keyMap, new ArrayList<>());
            mainMap.get(keyMap).add(word);
        }
        return new ArrayList<>(mainMap.values());
    }

}
