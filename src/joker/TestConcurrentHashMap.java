package joker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String , String> chm = new ConcurrentHashMap<>();
		
		chm.put("1", "A");
		chm.putIfAbsent("1", "B");
		chm.putIfAbsent("2", "B");
		
		System.out.println(chm);
		
		chm.computeIfAbsent("3", k -> "C");
		System.out.println(chm);
		
		chm.computeIfAbsent("3", k -> "D");
		System.out.println(chm);
		
		chm.computeIfPresent("3", (k,V) -> "D");
		System.out.println(chm);
		
		chm.computeIfPresent("4", (k,V) -> "E");
		System.out.println(chm);
		
		chm.compute("4", (k,V) -> "E");
		System.out.println(chm);
		
		chm.compute("4", (k,V) -> "F");
		System.out.println(chm);
	}

}
