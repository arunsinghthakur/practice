package joker.j8;

import java.util.stream.IntStream;

public class ASCIAdd {

	public static void main(String[] args) {
		char[] a = new char[]{'A','B','C'};
		
		
		IntStream.range(0, a.length).mapToObj(c->a[c]).map(c1 -> (int)c1).reduce(Integer::sum).ifPresent(System.out::print);
	}

}
