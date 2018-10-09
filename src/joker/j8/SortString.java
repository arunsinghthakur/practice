package joker.j8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortString {

	public static void main(String[] args) {
		Map<String, Integer> m = new MyMap();
		m.put("ONE", 1);
		m.put("NINE", 9);
		m.put("TWO", 2);
		//m.put(null, 2);
		
		List<String> list = new ArrayList<>();
		list.add("NINE");
		list.add("ONE");
		list.add("TWO");
		System.out.println(list);
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return m.get(o1).compareTo(m.get(o2));
			}
		});
		
		System.out.println(list);
	}

}


class MyMap extends HashMap<String, Integer> {
	@Override
	public Integer put(String key, Integer value) {
		if(null == key) {
			throw new IllegalArgumentException();
		}
		return super.put(key, value);
	}
}