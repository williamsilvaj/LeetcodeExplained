import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the mapping of values to indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array and map the elements
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Iterate through the array and search for the complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map and it's not the same element
            if (map.containsKey(complement) && map.get(complement) != i) {
                // Return the indices
                return new int[]{i, map.get(complement)};
            }
        }

        // If no solution is found, return [-1, -1]
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Example usage
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
