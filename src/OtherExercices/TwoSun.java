package OtherExercices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSun {

    static void main() {
        int[] nums = {11, 15, 2, 7};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result));

        int[] nums2 = {3, 3};
        int[] result2 = twoSum(nums2, 6);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
