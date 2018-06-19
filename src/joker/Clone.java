package joker;

public class Clone implements Cloneable{
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		new Clone().clone();

	}

}
