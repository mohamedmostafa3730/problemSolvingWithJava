
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
    

    /*
     * Algorithm Doc:
     * [1] Name => groupAnagramsSort
     * [2] Assumptions => 
     *  (1- The output is any order
     *  (2- anagram is a string that contains the exact same characters as another string, but the order of the characters can be different
     *  (3- Characters is made up of lowercase English letters
     * [3] inputs =>  Array of String 
     * [4] processes: 
     *  (1) validations => 
     *      (1- check of lowercase English letters
     *      (2- check of Array is not empty
     *      (3- check of Array has only String, hasn't number
     *      (4- have one element
     *  (2) main processes => 
     *      (1- create object from HashMap class and implement Map interface, 
     *      (2- loop on input array of string
     *          (1- convert the string to Arrays of Character, then store it
     *          (2- sort the Array of Character 
     *          (3- convert the Array of Character to String, then store it 
     *          (4- add the sorting string in HashMap as a key , if story before, ifn't crete new object from Array List to store in it,
     *          (5- add string in HashMap as a values with key
     *      (3- crete a object from ArrayList, then inject the values of HashMap 
     *  (3) memory using:
     *      (1- global:
     *          (1- HashMap with  Map, List interfaces, Map < Integer , List < String > >
     *      (2- locale:
     *          (1- Array of Character
     *          (2- String variable
     * [5] output => ArrayList<>()
     * [6] Complicity:
     *  (1) Time complicity => O(m * n log n)
     *  (2) Memory complicity => O(m * n)
     *      - m => the number of String
     *      - n => the number of character for every String
     * [7] Data Structure => HashMap, Array, ArrayList
     * [8] techniques => Categories String By Count
     */
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
