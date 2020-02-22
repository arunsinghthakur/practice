package joker.ds.string;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {
    public static void main(String[] args) {
        String s = "hhpddlnnsjfoyxpciioigvjqzfbpllssuj";
        System.out.print(anagram(s));
    }

    static int anagram(String s) {
        if (s.length() % 2 != 0) return -1;

        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2, s.length());

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Map<Character, Long> m1 = IntStream.range(0, c1.length).
                mapToObj(i -> c1[i]).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> m2 = IntStream.range(0, c2.length).
                mapToObj(i -> c2[i]).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final int[] m = {0};
        m1.keySet().stream().forEach(k -> {
            if (m2.containsKey(k)) {
                long r = m1.get(k) - m2.get(k);
                m[0] += (r < 0 ? 0 : r);
            } else {
                m[0] += m1.get(k);
            }
        });
        return m[0];
    }
}
