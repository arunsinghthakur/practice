package joker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Immutable {

	public static void main(String[] args) {
		HashMap<Integer, List> h = new HashMap<Integer, List>();
		h.put(1, null);
		Map<Integer, List> m = Collections.unmodifiableMap(h);
		System.out.println(m);
		h.put(1, new ArrayList<>());
		System.out.println(m);
		m.get(1).add(1212);
		System.out.println(m);
	}

}
