package joker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Collections {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Map<String, String> map = new HashMap<>();
		Set<String> tset = new TreeSet<>();
		Map<String, String> tmap = new TreeMap<>();

		list.add(null);
		set.add(null);
		map.put(null, null);
		map.put(null, "test");
		System.out.println(map.get(null));
		tset.add(null);
		tmap.put(null, null);
		
		
	}

}
