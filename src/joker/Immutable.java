package joker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Immutable {

	public static void main(String[] args) {
		/*HashMap<Integer, List> h = new HashMap<Integer, List>();
		h.put(1, null);
		Map<Integer, List> m = Collections.unmodifiableMap(h);
		System.out.println(m);
		h.put(1, new ArrayList<>());
		System.out.println(m);
		m.get(1).add(1212);
		System.out.println(m);*/
		
		
		//
		
		//Collections.unmodifiableList(Arrays.asList(1,2,3)).add(4);
		//Collections.singletonList(Arrays.asList(1,2,3)).add(Arrays.asList(1,2,3));
		//Map m = new HashMap<Integer, Integer>();m.put(1,2);
		//Collections.unmodifiableMap(m).put(1, 1);
		
		//Map m = new HashMap<Integer, List>();m.put(1,Arrays.asList(1,2));
		//java.util.Collections.unmodifiableMap(m).put(1, Arrays.asList(3,4));
		
		Map<Integer, List> m = new HashMap<Integer, List>();m.put(1,Arrays.asList(1,2));
		//java.util.Collections.unmodifiableMap(m).get(1).addAll(Arrays.asList(1,2,3));
		java.util.Collections.unmodifiableMap(m).get(1).add(4);
	}

}
