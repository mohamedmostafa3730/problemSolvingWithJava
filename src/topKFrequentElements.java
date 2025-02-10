
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

    // Time complicity => O(n log n)
    // memory complicity => O(n)
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
