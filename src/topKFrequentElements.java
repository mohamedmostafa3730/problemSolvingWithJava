
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topKFrequentElements {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1, 2, 5, 2, 6, 3, 1, 3, 2, 1, 3, 4, 2, 1, 3, 5, 2, 1, 2};
        System.out.println(Arrays.toString(topKFreqElements(nums, 6)));
    }


    /*
     * Algorithm Doc:
     * [1] Name => topKFreqElementsSorting();
     * [2] Assumptions => 
     *  (1- output in any order
     * [3] inputs =>
     *  (1- Array of integer
     *  (2- integer variable (key)
     * [4] processes: 
     *  (1) validations => 
     *      (1- check if Array is Empty or not
     *      (2- check of array contain only integer values
     *  (2) main processes => 
     *      (1- create a object form HashMap class and implement Map interface, and store it 
     *      (2- loop on Array of integer 
     *          (1- add the item as a key and Frequent as a value in Map   
     *      (3- create a object form ArrayList class and implement List interface, and store it
     *      (4- loop on map in key and value in Parallel, with crete object from Map.entry interface, and use EntrySet() method 
     *          (1- replace all of keys of map to values of ArrayList, with entry object; 
     *          (2- replace all of values of map to Keys of ArrayList, with entry object;
     *      (5- sort descending order an ArrayList with arrow function (lambda function)
     *      (6- create a integer array with (key) length, to return it
     *      (7- loop on ArraysList after sorted 
     *          (1- add item in integer array
     *      (8- return the integer array
     *  (3) memory using:
     *      (1- global:
     *          (1- HashMap with Map interface; 
     *          (2- ArrayList with List interface; 
     *          (3- Array of integer; 
     *      (2- locale: 0;
     * [5] output => Array of integer;
     * [6] Complicity:
     *  (1) Time complicity => O(n log n)
     *  (2) Memory complicity => O(n)
     * [7] Data Structure => 
     *  (1) HashMap, Array, ArrayList;
     * [8] techniques =>  Frequency Count, Sorting by Frequency
     */
    public static int[] topKFreqElements(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
