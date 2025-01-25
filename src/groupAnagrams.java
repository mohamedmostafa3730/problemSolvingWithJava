
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

    public static void main(String[] args) {
        String[] words = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(Arrays.toString(words));
        System.out.println("-----------------------------");
        List<List<String>> res = groupAnagramsSolOne(words);
        System.out.println(res);
    }

    //solution one
    public static List<List<String>> groupAnagramsSolOne(String[] words) {
        Map<String, List<String>> MapGroupAnagrams = new HashMap<>();
        for (String s : words) {
            char[] characterArray = s.toCharArray();
            Arrays.sort(characterArray);
            String NewWord = new String(characterArray);
            MapGroupAnagrams.putIfAbsent(NewWord, new ArrayList<>());
            MapGroupAnagrams.get(NewWord).add(s);
        }
        return new ArrayList<>(MapGroupAnagrams.values());
    }

}
