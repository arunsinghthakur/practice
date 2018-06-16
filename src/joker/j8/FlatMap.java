package joker.j8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a simple text".split(" "));

		// list.stream().forEach(System.out::print);

		list.stream().map(s -> s.toCharArray()).collect(Collectors.toList()).stream().filter(s -> s.length > 4).forEach(System.out::print);
	}

}
