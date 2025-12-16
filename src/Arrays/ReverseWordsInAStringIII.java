import java.util.stream.IntStream;

public class ReverseWordsInAStringIII {

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int l = 0, r = 0;

        while (r < s.length()) {
            if (s.charAt(r) != ' ') {
                r++;
            } else {
                res.append(new StringBuilder(s.substring(l, r + 1)).reverse());
                r++;
                l = r;
            }
        }

        res.append(" ");
        res.append(new StringBuilder(s.substring(l, r)).reverse());
        return res.substring(1);
    }

    public static void main(String[] args) {
        String result = reverseWords("Bananas Pijama");
        System.out.println(result);
    }
}