package joker.ds.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringReplace {

    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, Comparator.comparing(String::length));

        for(final String d: dict) {
            sentence = Arrays.stream(sentence.split(" ")).map(s -> findNReplace(s,d)).collect(Collectors.joining());
        }
        return sentence;
    }

    private String findNReplace(String s, String d){
        if(s.startsWith(d)) return d;
        return s;
    }

    public static void main(String[] args) {

    }
}
