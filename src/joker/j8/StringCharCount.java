package joker.j8;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCharCount {
	public static void main(String[] args) {
		String s = "AAABBAABBCCCS";

		Map<Object, Long> r = Arrays.stream(s.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		System.out.println(r);

	}
}
