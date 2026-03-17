package Arrays;

import java.util.*;

public class IntersectionofTwoArrays {
    static void main() {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        int[] result = intersect(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int n : nums1) {
            map.put(n, 1);
        }
        for (int n : nums2) {
            if (map.containsKey(n)) {
                set.add(n);
            }
        }
        return set.stream().mapToInt(x -> x).toArray();
    }

}
