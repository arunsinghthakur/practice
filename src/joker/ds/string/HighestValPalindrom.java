package joker.ds.string;

import java.util.*;

public class HighestValPalindrom {

    static String highestValuePalindrome(String s, int n, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> m1 = new HashMap<>();

        int l = 0;
        int h = s.length() - 1;
        int max = 9;//s.chars().max().getAsInt() - 48;
        int k1 = k;

        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                int l1 = s.charAt(l) - 48;
                int h1 = s.charAt(h) - 48;
                int index = s.charAt(l) > s.charAt(h) ? h : l;
                if (l1 != max) {
                    m1.put(l, max);
                }
                if (h1 != max) {
                    m1.put(h, max);
                }
                m.put(index, Math.max(l1, h1));

                --k1;
            } else if (m1.size() + 2 <= k && max != (s.charAt(l) - 48)) {
                m1.put(l, max);
                m1.put(h, max);
            }
            if (k1 < 0) {
                return "-1";
            }
            ++l;
            --h;
        }

        if (s.length() % 2 != 0) {
            int z = s.length() / 2;
            if (m1.size() < k && (s.charAt(z) - 48) != max)
                m1.put(z, max);
        }

        Iterator<Map.Entry<Integer, Integer>> itr = m1.size() <= k ? m1.entrySet().iterator() : m.entrySet().iterator();
        char[] arr = s.toCharArray();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            int key = entry.getKey();
            int val = entry.getValue() + 48;
            arr[key] = (char) val;

        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "11331";
        int n = 5;
        int k = 4;
        System.out.print(highestValuePalindrome(s, n, k));
    }
}
