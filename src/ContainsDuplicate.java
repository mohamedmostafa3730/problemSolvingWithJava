
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,2,3,1};
        System.out.println("===============");
        System.out.println(ContainsDuplicateBruteForce(nums1));
        System.out.println("---------------");
        System.out.println(ContainsDuplicateBruteForce(nums2));
        System.out.println("===============");
        System.out.println(ContainsDuplicateSorting(nums1));
        System.out.println("---------------");
        System.out.println(ContainsDuplicateSorting(nums2));
        System.out.println("===============");
        System.out.println(ContainsDuplicateHashSet(nums1));
        System.out.println("---------------");
        System.out.println(ContainsDuplicateHashSet(nums2));
        System.out.println("===============");

    }

    //  Time complicity => O(n^2)
    //  memory complicity => O(1)
    public static boolean ContainsDuplicateBruteForce(int[] nums){
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    } 

    //  Time complicity => O(n log n)
    //  memory complicity => O(1) || O(n) => depending on the sorting algorithm
    public static boolean ContainsDuplicateSorting(int[] nums){
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    // Time complicity => O(n)
    // Time memory => O(n)
    public static boolean ContainsDuplicateHashSet(int[] nums){
        Set<Integer> container = new HashSet<>();
        for(int num:nums){
            if (container.contains(num)) {
                return true;
            }
            container.add(num);
        }
        return false;
    }
}
