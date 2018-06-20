package joker;

public class Clone implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// super.clone();
		return "hello";
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println(new Clone().clone());
	}

}
