package joker;

import java.util.HashSet;
import java.util.Set;

public class MapHashCheck {
	public static void main(String[] args) {
		Set<A> set = new HashSet<>();
		set.add(new A(1, "A"));
		set.add(new A(2, "B"));
		set.add(new A(1, "A"));

		System.out.println(set.size());
	}
}

class A {
	private int i;
	private String j;

	public A(int i, String j) {
		super();
		this.i = i;
		this.j = j;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + ((j == null) ? 0 : j.hashCode());
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (i != other.i)
			return false;
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		return true;
	}

	
	/*@Override
	public int hashCode() {
		return -1;
	}*/
}
