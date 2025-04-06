import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _3Sum {
    public static void main(String[] args) {
        int[] nums = { -100000, 0, 100000 };
        System.out.println("================================================");
        System.out.println(_3SumBruteForce(nums));
        System.out.println("================================================");
    }
    /* 
    * ( _3Sum BruteForce )]
    * [1] Name: _3SumBruteForce() ;
    * [2] Assumptions:
    *      1> the indices i, j and k are all distinct;
    *      2> The output should not contain any duplicate triplets;
    *      3> return the output and the triplets in any order;
    * [3] Inputs: Array of Integer ;
    * [4] processes:
    *      (1) validation: (-)
    *      (3) Main Processes:
    *          1- create object from HashSet class and implement Set interface;
    *          2-  sort the Array using (Array.sort());
    *          3- loop at start of array
    *               3-1 loop at start + 1 of array
    *                   3-1-1 loop at start + 1 + 1 of array
    *                       3-1-1-1 check if 3 iterators = 0,
    *                           3-1-1-1-1 if true, create temp object implement List interface, declare it with 3 iterators
    *                           3-1-1-1-2 add temp object in set
    *           4- return set object as a ArrayList<>();
    *      (2) Memory Using:
    *          1) global => (result) => object from HashSet class and implement Set interface;
    *          2) locale => (temp) => object implement List interface;
    * [5] complicity:
    *      (1) time complicity => O(n^3);
    *      (2) memory complicity => O(m), m is number of triplets;
    *       
    * [6] OutPuts: List of List form Integer;
    * [7] built in using:
    *      (1) using (HashSet<>()) class, with Set interface, as a DataStructure; 
    *      (2) using (Arrays.Sort()) function, to sort the input Array;
    *      (3) using (List<>) interface, as a DataStructure, to store temp of 3 iterators;
    *      (4) using (Arrays.asList()) function, to add 3 iterators as a list to temp list;
    *      (5) using (ArrayList<>()) class, as a DataStructure, to return result Array;
    * [8] Algorithm techniques: Brute Force ;
    */
    public static List<List<Integer>> _3SumBruteForce(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

}
