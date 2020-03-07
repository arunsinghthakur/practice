package joker.ds.trie;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Trie {
    Map<Character, LinkedHashMap> root;

    public Trie() {
        root = new LinkedHashMap<>();
    }

    public void insert(String word) {
        Map<Character, LinkedHashMap> temp = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.get(c) == null) {
                temp.put(c, new LinkedHashMap());
                temp = temp.get(c);
            } else {
                temp = temp.get(c);
            }
        }
        temp.put('\0', new LinkedHashMap());
    }

    public boolean search(String word) {
        Map<Character, LinkedHashMap> temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.get(c) == null) {
                return false;
            } else {
                temp = temp.get(c);
            }
        }
        return temp.containsKey('\0');
    }

    public boolean startsWith(String word) {
        Map<Character, LinkedHashMap> temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.get(c) == null) {
                return false;
            } else {
                temp = temp.get(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
