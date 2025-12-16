import java.util.HashMap;
import java.util.Map;

public class Palindromos {
    public static void main(String[] args) {
        String input = "abc";
        palindrosmos(input);
    }

    public static void palindrosmos(String input) {
        Map<Character, Integer> map = new HashMap<>();
        Integer count = 0;
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Integer freq : map.values()) {
            if (freq % 2 != 0) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("0");
        } else {
            System.out.println(count - 1);
        }
    }
}
