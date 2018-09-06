package joker;

public class Inher {

	public static void main(String[] args) {
		new C("joer").print();

	}

}

abstract class Top{
	Top(String s){
		System.out.println("A"  + s);
	}
	
	void print(){
		System.out.println("A");
	}
}

class B extends Top{
	B(String s){
		super(s);
		System.out.println("B"+s);
	}
	
	void print(){
		System.out.println("B");
	}
}

class C extends B{
	C(String s){
		super(s);
		System.out.println("C"+s);
	}
	
	void print(){
		System.out.println("C");
	}
}