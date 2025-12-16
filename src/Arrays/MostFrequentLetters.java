import java.util.*;

public class MostFrequentLetters {
    public static void main(String[] args) {
        String words = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus mauris lorem, ultrices id elit lobortis, euismod euismod arcu. Mauris ut ipsum ac neque vehicula cursus vel non nulla. Suspendisse volutpat libero id enim ultrices lacinia fermentum sed ipsum. Praesent id sagittis nunc. Phasellus scelerisque pharetra ligula, vel tincidunt dui commodo nec.";
        countLetterMostFrequent(words.toLowerCase());
    }

    public static void countLetterMostFrequent(String words) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> letterMostFrequent = new ArrayList<>();
        Integer maxFrequent = 0;

        for (Character l : words.toCharArray()) {
            if (l >= 'a' && l <= 'z') {
                map.put(l, map.getOrDefault(l, 0) + 1);
            }
        }


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFrequent) {
                maxFrequent = entry.getValue();
                letterMostFrequent.clear();
                letterMostFrequent.add(entry.getKey());
            }
            if (entry.getValue() == maxFrequent) {
                letterMostFrequent.add(entry.getKey());
            }
        }
        Collections.sort(letterMostFrequent);
        System.out.println("Letter: " + letterMostFrequent.toString());
        System.out.println("Count: " + maxFrequent);
    }

}
