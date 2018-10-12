package joker;

import java.util.HashSet;
import java.util.Set;

public class Pair {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,6,7,-1};
		Set<Integer> s = new HashSet<>();
		int sum = 6;
		for(int i : arr) {
			if(s.contains(sum-i)) {
				System.out.println(i + "----" + (sum-i));
			}
			s.add(i);
		}
		
	}
	
}
