
import java.util.Arrays;

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

}
