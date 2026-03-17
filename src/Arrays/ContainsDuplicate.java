package Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    static void main() {

    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            }
            map.put(i, 1);
        }
        return false;
    }

}
