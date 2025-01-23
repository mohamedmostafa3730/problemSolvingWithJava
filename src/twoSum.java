
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 2, 3, 4, 3, 2};
        System.out.println(Arrays.toString(twoSumBruteForce(arr, 4)));

    }

    /* 
     * time complicity => O(n^2)
     * memory complicity => O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * time complicity => O(n) 
     * memory complicity => O(n)
     */
    public static int[] towSumHashMaPTwoPass(int[] nums, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            twoSumMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (twoSumMap.containsKey(diff) && twoSumMap.get(diff) != i) {
                return new int[]{i, twoSumMap.get(diff)};
            }
        }

        return new int[0];
    }

    public static int[] towSumHashMaPOnePass(int[] nums, int target) {
        HashMap<Integer, Integer> twoSumMap = new HashMap<>();
        int num, diff;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            diff = target - num;
            if (twoSumMap.containsKey(diff)) {
                return new int[]{twoSumMap.get(diff), i};
            }
            twoSumMap.put(num, i);
        }
        return new int[]{0};
    }

}
