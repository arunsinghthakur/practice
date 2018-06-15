package joker.j8;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicate {
	public static void main(String[] args) {
		System.out.println("Method 1");
		printUnique(new int[] { 1, 1, 2, 2, 3, 3, 3, 3, 4 });
		System.out.println("\nMethod 2");
		printDuplicate(new int[] { 1, 1, 2, 2, 3, 3, 3, 3, 4 });
		System.out.println("\nMethod 3");
		printDuplicate2(new Integer[] { 1, 1, 2, 2, 3, 3, 3, 3, 4 });
	}

	static void printUnique(int[] array) {
		Arrays.stream(array).distinct().forEach(System.out::print);
	}

	static void printDuplicate(int[] array) {
		Set<Integer> s = new HashSet<Integer>();
		Arrays.stream(array).forEach(e -> {
			if (!s.add(e)) {
				System.out.print(e);
			}
		});
	}

	static void printDuplicate2(Integer[] array) {
		List<Integer> list = Arrays.asList(array);
		String r = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet()).stream().map(String::valueOf)
				.collect(Collectors.joining(" , "));
		System.out.println(r);
	}
}
