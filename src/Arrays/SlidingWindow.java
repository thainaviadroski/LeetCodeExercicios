import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
	public static void main(String[] args) {
		String str = "bcbbbcba";
		System.out.println(maxLengthSubstring(str));
	}

	public static Integer maxLengthSubstring(String s) {
		Map<Character, Integer> counter = new HashMap<>();
		Integer left = (Integer) 0, right = (Integer) 0;
		Integer max = (Integer) 1;

		counter.put(s.charAt(0), 1);

		while (right < s.length()- 1) {
			char currentStr = s.charAt(right);
			right += 1;
			if (counter.containsKey(currentStr)) {
				counter.put(currentStr, counter.getOrDefault(currentStr, 0) + 1);
			} else {
				counter.put(currentStr, 1);
			}

			while (counter.get(currentStr) == 3) {
				char leftStr = s.charAt(left);
				counter.put(leftStr, counter.get(leftStr) - 1);
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}