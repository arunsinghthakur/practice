package joker.ds.string;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

public class Sherlock {

    static String isValid(String s) {

        Map<Character, Integer> m = s.chars().boxed().collect(Collectors.toMap(k -> Character.valueOf((char) k.intValue()),
                v -> 1, Integer::sum));
        Set<Integer> set = new HashSet<>(m.values());
        if (set.size() == 1) return "YES";

        List<Integer> list = new ArrayList<>(m.values());
        int sub = 0;
        for (int i = 0; i < list.size(); i++) {
            sub = list.get(i) - sub;
        }
        return Math.abs(sub) == 1 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.print(isValid("aabbcd"));
    }
}
